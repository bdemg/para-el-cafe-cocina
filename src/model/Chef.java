/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.IngredientsListManager;
import model.recipe.Recipe;

/**
 *
 * @author Jorge A. Cano
 */
public class Chef {
    
    private static final Chef chef = new Chef();
    
    
    private Chef(){
        ;
    }
    
    
    public static Chef callChef(){
        
        return chef;
    }

    public void createIngredientsList( Order input_order ) {
        
        Cookbook cookbook = Cookbook.getInstance();
        Recipe recipe = cookbook.getRecipe( input_order.getProductName() );
        
        Object[][] rawIngredients = recipe.getIngredients();
        Object[][] adjustedIngredients = this.adjustIngredientsQuantity( input_order.getProductQuantity(),
                rawIngredients );
        IngredientsList ingredientsList = new IngredientsList( adjustedIngredients );
        
        new IngredientsListManager( ingredientsList, input_order );
    }

    private Object[][] adjustIngredientsQuantity( int input_productQuantity, Object[][] mod_ingredients ) {
        
        for ( Object[] ingredientDescription : mod_ingredients ) {
            
            Measurement measurementType = identifyMeasurementType( 
                ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ]);
            
            if ( measurementType == Measurement.WHOLE_NUMBER ) {
                ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ] = 
                        ( (int) ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ] *
                        input_productQuantity );
                
            } else {
                Fraction ingredientQuantity = 
                        (Fraction) ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ];
                ingredientQuantity.setNumerator( ingredientQuantity.getNumerator() *
                        input_productQuantity );
                
                ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ] = ingredientQuantity;
            }
        }
        return mod_ingredients;
    }

    private Measurement identifyMeasurementType( Object input_ingredientQuantity ) {
        
        if(input_ingredientQuantity instanceof Integer){
            return Measurement.WHOLE_NUMBER;
        }
        else{
            return Measurement.FRACTION;
        }
    }
}
