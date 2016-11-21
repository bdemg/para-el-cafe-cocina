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

public class RedVelvetCakeRecipe implements Recipe{
    
    private final int TOTAL_INGREDIENTS = 12;
    
    private final int FLOUR_QUANTITY = 250;
    private final int FLOUR_DESCRIPTION = 0;
    
    private final int SUGAR_QUANTITY = 250;
    private final int SUGAR_DESCRIPTION = 1;
    
    private final int CHOCOLATE_QUANTITY = 1;
    private final int CHOCOLATE_DESCRIPTION = 2;
    
    private final int SALT_QUANTITY = 1;
    private final int SALT_DESCRIPTION = 3;
    
    private final int BAKING_POWDER_QUANTITY = 14;
    private final int BAKING_POWDER_DESCRIPTION = 4;
    
    private final int EGGS_QUANTITY = 2;
    private final int EGGS_DESCRIPTION = 5;
    
    private final int OIL_QUANTITY = 200;
    private final int OIL_DESCRIPTION = 6;
    
    private final int YOGURTH_NATURAL_QUANTITY = 75;
    private final int YOGURTH_NATURAL_DESCRIPTION = 7;
    
    private final int COLORANT_RED_QUANTITY = 1;
    private final int COLORANT_RED_DESCRIPTION = 8;
    
    private final int VINEGAR_QUANTITY = 1;
    private final int VINEGAR_DESCRIPTION = 9;
    
    private final int VANILLA_QUANTITY = 3;
    private final int VANILLA_DESCRIPTION = 10;
    
    private final int MILK_QUANTITY = 200;
    private final int MILK_DESCRIPTION = 11;

    @Override
    public Object[][] getIngredients() {
        Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][RedVelvetCakeRecipe.PROPERTIES];
        
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.FLOUR;
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.FLOUR_QUANTITY;
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.SUGAR;
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.SUGAR_QUANTITY;
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.CHOCOLATE_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.CHOCOLATE;
        outputRecipe[ this.CHOCOLATE_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.CHOCOLATE_QUANTITY;
        outputRecipe[ this.CHOCOLATE_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TEASPOON;
        
        outputRecipe[ this.SALT_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.SALT;
        outputRecipe[ this.SALT_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.SALT_QUANTITY;
        outputRecipe[ this.SALT_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TEASPOON;
        
        outputRecipe[ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.BAKING_POWDER;
        outputRecipe[ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.BAKING_POWDER_QUANTITY;
        outputRecipe[ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.EGGS;
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.EGGS_QUANTITY;
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.PIECE;
        
        outputRecipe[ this.OIL_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.OIL;
        outputRecipe[ this.OIL_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.OIL_QUANTITY;
        outputRecipe[ this.OIL_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.YOGURTH_NATURAL_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.YOGURTH_NATURAL;
        outputRecipe[ this.YOGURTH_NATURAL_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.YOGURTH_NATURAL_QUANTITY;
        outputRecipe[ this.YOGURTH_NATURAL_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.COLORANT_RED_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.COLORANT_RED;
        outputRecipe[ this.COLORANT_RED_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.COLORANT_RED_QUANTITY;
        outputRecipe[ this.COLORANT_RED_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TEASPOON;
        
        outputRecipe[ this.VINEGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.VINEGAR;
        outputRecipe[ this.VINEGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.VINEGAR_QUANTITY;
        outputRecipe[ this.VINEGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TEASPOON;
        
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
                Units.TABLESPOON;
        
        return outputRecipe;
    }
    
}
