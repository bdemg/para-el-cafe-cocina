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

    public void createIngredientsList(Order inputOrder) {
        Cookbook cookbook = Cookbook.getInstance();
        Recipe recipe = cookbook.getRecipe(inputOrder.getProductName());
        String[][] unadjustedIngredients = recipe.getIngredients();
        String[][] adjustedIngredients = this.adjustIngredientsQuantity(
                inputOrder.getProductQuantity(), unadjustedIngredients);
        IngredientsList ingredientsList = new IngredientsList(adjustedIngredients);
        new IngredientsListManager(ingredientList);
    }

    private static final int INGREDIENT_QUANTITY = 1;

    private String[][] adjustIngredientsQuantity(int inputProductQuantity, String[][] modIngredients) {
        for (int ingredientsCount = 0; ingredientsCount < modIngredients.length; ingredientsCount++) {
            modIngredients[ingredientsCount][Chef.INGREDIENT_QUANTITY] = String.valueOf(
                    Integer.valueOf(modIngredients[ingredientsCount][Chef.INGREDIENT_QUANTITY]) * inputProductQuantity);
        }
        return modIngredients;
    }

}
