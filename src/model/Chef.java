/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.IngredientsListManager;
import model.recipe.Recipe;

/**
 * This class represents the main chef in the bakery.
 * @author Jorge A. Cano
 */
public class Chef {
    
    private static final Chef chef = new Chef();
    
    
    private Chef(){
        ;
    }
    
    
    public static Chef callChef(){
        
        return Chef.chef;
    }

    
    //create the list of ingredients that is going to be needed in order to bake an order
    public void createIngredientsList( Order input_order ) {
        
        Cookbook cookbook = Cookbook.getInstance();
        Recipe recipe = cookbook.getRecipe( input_order.getProductName() );
        
        Object[][] baseIngredients = recipe.getIngredients();
        Object[][] adjustedIngredients = this.adjustIngredientsQuantity( input_order.getProductQuantity(),
                baseIngredients );
        
        IngredientsList ingredientsList = new IngredientsList( adjustedIngredients );
        new IngredientsListManager( ingredientsList, input_order );
    }

    
    //adjust the ingredient quantities based on the 
    private Object[][] adjustIngredientsQuantity( 
        int input_productQuantity,
        Object[][] mod_ingredients
    ) {
        
        for ( Object[] ingredientDescription : mod_ingredients ) {
            
            IngerientMeasurement measurementType = identifyMeasurementType( 
                ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ]);
            
            //the ingredient quantity is adjusted differently, depending if it is a whole number or a fraction
            if ( measurementType == IngerientMeasurement.WHOLE_NUMBER ) {
                
                ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ] =
                    this.adjustWholeIngredientQuantity(
                        (int) ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ],
                        input_productQuantity 
                    );
                
            } else {
                
                ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ] = 
                    this.adjustFractionaryIngredientQuantity(
                        (Fraction) ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ],
                        input_productQuantity
                    );
            }
        }
        return mod_ingredients;
    }

    
    //see if the measurement of an ingredient is in a fraction or a whole number
    private IngerientMeasurement identifyMeasurementType( Object input_ingredientQuantity ) {
        
        if( input_ingredientQuantity instanceof Integer ){
            return IngerientMeasurement.WHOLE_NUMBER;
        }
        else{
            return IngerientMeasurement.FRACTION;
        }
    }
    
    
    //adjust a whole or integer ingedient quantity to a given product quantity
    private int adjustWholeIngredientQuantity(
        int input_ingredientQuantity,
        int input_productQuantity
    ){
        
        return input_ingredientQuantity * input_productQuantity;
    }
    
    
    private Fraction adjustFractionaryIngredientQuantity(
        Fraction mod_ingredientQuantity,
        int input_productQuantity
    ){
        
        mod_ingredientQuantity.setNumerator( mod_ingredientQuantity.getNumerator() *
            input_productQuantity );
        
        return mod_ingredientQuantity;
    }
}
