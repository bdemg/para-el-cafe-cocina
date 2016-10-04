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
        Object[][] unadjustedIngredients = recipe.getIngredients();
        Object[][] adjustedIngredients = this.adjustIngredientsQuantity(
                inputOrder.getProductQuantity(), unadjustedIngredients);
        IngredientsList ingredientsList = new IngredientsList(adjustedIngredients);
        //new IngredientsListManager(ingredientList);
    }

    private static final int INGREDIENT_QUANTITY = 1;

    private Object[][] adjustIngredientsQuantity(int inputProductQuantity, Object[][] modIngredients) {
        for (Object[] modIngredient : modIngredients) {
            if (ingredientQuantityIsInteger(modIngredient[Chef.INGREDIENT_QUANTITY])) {
                modIngredient[Chef.INGREDIENT_QUANTITY] = ((int) modIngredient[Chef.INGREDIENT_QUANTITY] * inputProductQuantity);
            } else {
                Fraction ingredientQuantity = (Fraction) modIngredient[Chef.INGREDIENT_QUANTITY];
                ingredientQuantity.setNumerator(ingredientQuantity.getNumerator() * inputProductQuantity);
                modIngredient[Chef.INGREDIENT_QUANTITY] = ingredientQuantity;
            }
        }
        return modIngredients;
    }

    private boolean ingredientQuantityIsInteger(Object inputIngredientQuantity) {
        return inputIngredientQuantity instanceof Integer;
    }
}
