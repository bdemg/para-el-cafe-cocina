/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.recipe;

import model.Fraction;
import model.IngredientsList;

/**
 *
 * @author Evan-Ian-Ray
 */

public class ButterCreamRecipe implements Recipe{
    
    private final int TOTAL_INGREDIENTS = 4;
    
    private final int BUTTER_QUANTITY = 250;
    private final int BUTTER_DESCRIPTION = 0;
    
    private final int GLASS_SUGAR_QUANTITY = 350;
    private final int GLASS_SUGAR_DESCRIPTION = 1;
    
    private final int VANILLA_QUANTITY = 1;
    private final int VANILLA_DESCRIPTION = 2;
    
    private final int MILK_QUANTITY = 1;
    private final int MILK_DESCRIPTION = 3;

    @Override
    public Object[][] getIngredients() {

        Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][ButterCreamRecipe.PROPERTIES];
        
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.BUTTER;
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.BUTTER_QUANTITY;
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.GLASS_SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.GLASS_SUGAR;
        outputRecipe[ this.GLASS_SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.GLASS_SUGAR_QUANTITY;
        outputRecipe[ this.GLASS_SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.VANILLA_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.VANILLA;
        outputRecipe[ this.VANILLA_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.VANILLA_QUANTITY;
        outputRecipe[ this.VANILLA_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TEASPOON;
        
        outputRecipe[ this.MILK_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.MILK;
        outputRecipe[ this.MILK_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.MILK_QUANTITY;
        outputRecipe[ this.MILK_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TEASPOON;
        
        return outputRecipe;
    }
    
}
