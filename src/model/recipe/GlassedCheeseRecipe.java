/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.recipe;

import model.IngredientsList;

/**
 *
 * @author Evan-Ian-Ray
 */

public class GlassedCheeseRecipe implements Recipe{

    private final int TOTAL_INGREDIENTS = 5;
    
    private final int CREAM_CHEESE_QUANTITY = 600;
    private final int CREAM_CHEESE_DESCRIPTION = 0;
    
    private final int GLASS_SUGAR_QUANTITY = 300;
    private final int GLASS_SUGAR_DESCRIPTION = 1;
    
    private final int BUTTER_QUANTITY = 200;
    private final int BUTTER_DESCRIPTION = 2;
    
    private final int VANILLA_QUANTITY = 1;
    private final int VANILLA_DESCRIPTION = 3;
    
    private final int SALT_QUANTITY = 1;
    private final int SALT_DESCRIPTION = 4;

    @Override
    public Object[][] getIngredients() {
       Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][GlassedCheeseRecipe.PROPERTIES];
        
        outputRecipe[ this.CREAM_CHEESE_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.CREAM_CHEESE;
        outputRecipe[ this.CREAM_CHEESE_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.CREAM_CHEESE_QUANTITY;
        outputRecipe[ this.CREAM_CHEESE_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.GLASS_SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.GLASS_SUGAR;
        outputRecipe[ this.GLASS_SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.GLASS_SUGAR_QUANTITY;
        outputRecipe[ this.GLASS_SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.BUTTER;
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.BUTTER_QUANTITY;
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.VANILLA_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.VANILLA;
        outputRecipe[ this.VANILLA_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.VANILLA_QUANTITY;
        outputRecipe[ this.VANILLA_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TEASPOON;
        
        outputRecipe[ this.SALT_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.SALT;
        outputRecipe[ this.SALT_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.SALT_QUANTITY;
        outputRecipe[ this.SALT_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.PIZCA;
        
        return outputRecipe;
    }
    
}
