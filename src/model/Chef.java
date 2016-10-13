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

    public void createIngredientsList( Order inputOrder ) {
        
        Cookbook cookbook = Cookbook.getInstance();
        Recipe recipe = cookbook.getRecipe( inputOrder.getProductName() );
        
        Object[][] rawIngredients = recipe.getIngredients();
        Object[][] adjustedIngredients = this.adjustIngredientsQuantity( inputOrder.getProductQuantity(),
                rawIngredients );
        IngredientsList ingredientsList = new IngredientsList( adjustedIngredients );
        
        new IngredientsListManager( ingredientsList );
    }

    private Object[][] adjustIngredientsQuantity( int inputProductQuantity, Object[][] modIngredients ) {
        
        for ( Object[] ingredientDescription : modIngredients ) {
            
            if ( isInteger( ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ] ) ) {
                ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ] = 
                        ( (int) ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ] *
                        inputProductQuantity );
                
            } else {
                Fraction ingredientQuantity = 
                        (Fraction) ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ];
                ingredientQuantity.setNumerator( ingredientQuantity.getNumerator() *
                        inputProductQuantity );
                
                ingredientDescription[ Cookbook.INGREDIENT_QUANTITY ] = ingredientQuantity;
            }
        }
        return modIngredients;
    }

    private boolean isInteger( Object inputIngredientQuantity ) {
        
        return inputIngredientQuantity instanceof Integer;
    }
}
