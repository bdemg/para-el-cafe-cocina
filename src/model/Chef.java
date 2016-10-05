/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.recipe.Recipe;

/**
 *
 * @author Jorge A. Cano
 */
public class Chef {
    
    private static Chef instance = new Chef();
    
    private Chef(){
        ;
    }
    
    public static Chef getInstance(){
        return instance;
    }

    public void createIngredientsList(Order inputOrder) {
        Cookbook cookbook = Cookbook.getInstance();
        Recipe recipe = cookbook.getRecipe(inputOrder.getProductName());
        
        Object[][] unadjustedIngredients = recipe.getIngredients();
        Object[][] adjustedIngredients = this.adjustIngredientsQuantity(inputOrder.getProductQuantity(),
                unadjustedIngredients);
        IngredientsList ingredientsList = new IngredientsList(adjustedIngredients);
        
        //new IngredientsListManager(ingredientList);
    }

    private Object[][] adjustIngredientsQuantity(int inputProductQuantity, Object[][] modIngredients) {
        for (Object[] modIngredient : modIngredients) {
            
            if (ingredientQuantityIsInteger(modIngredient[Cookbook.INGREDIENT_QUANTITY])) {
                modIngredient[Cookbook.INGREDIENT_QUANTITY] = ((int) modIngredient[Cookbook.INGREDIENT_QUANTITY] * inputProductQuantity);
                
            } else {
                Fraction ingredientQuantity = (Fraction) modIngredient[Cookbook.INGREDIENT_QUANTITY];
                ingredientQuantity.setNumerator(ingredientQuantity.getNumerator() * inputProductQuantity);
                modIngredient[Cookbook.INGREDIENT_QUANTITY] = ingredientQuantity;
            }
        }
        return modIngredients;
    }

    private boolean ingredientQuantityIsInteger(Object inputIngredientQuantity) {
        return inputIngredientQuantity instanceof Integer;
    }
}
