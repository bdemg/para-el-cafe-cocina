/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.recipe;

import model.IngredientsList;

/**
 *
 * @author Jorge A. Cano
 */
public class PerfectCupCakeRecipe implements Recipe{
    private final int TOTAL_INGREDIENTS = 9;
    
    private final int HONEY_QUANTITY = 2;
    private final int HONEY_DESCRIPTION = 0;
    
    private final int SUGAR_QUANTITY = 260;
    private final int SUGAR_DESCRIPTION = 1;
    
    private final int BAKING_POWDER_QUANTITY = 8;
    private final int BAKING_POWDER_DESCRIPTION = 2;
    
    private final int EGGS_QUANTITY = 188;
    private final int EGGS_DESCRIPTION = 3;
    
    private final int VANILLA_QUANTITY = 1;
    private final int VANILLA_DESCRIPTION = 4;
    
    private final int SALT_QUANTITY = 1;
    private final int SALT_DESCRIPTION = 5;
    
    private final int FLOUR_QUANTITY = 315;
    private final int FLOUR_DESCRIPTION = 6;
    
    private final int MILK_QUANTITY = 90;
    private final int MILK_DESCRIPTION = 7;
    
    private final int VEGETAL_OIL_QUANTITY = 285;
    private final int VEGETAL_OIL_DESCRIPTION = 8;
    
    
    @Override
    public Object[][] getIngredients() {
        
        Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][PerfectCupCakeRecipe.PROPERTIES];
        
        outputRecipe[ this.HONEY_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.HONEY;
        outputRecipe[ this.HONEY_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.HONEY_QUANTITY;
        outputRecipe[ this.HONEY_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TABLESPOON;
        
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.SUGAR;
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.SUGAR_QUANTITY;
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.BAKING_POWDER;
        outputRecipe[ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.BAKING_POWDER_DESCRIPTION;
        outputRecipe[ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.EGGS;
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.EGGS_QUANTITY;
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
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
        
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.FLOUR;
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.FLOUR_QUANTITY;
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.MILK_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.MILK;
        outputRecipe[ this.MILK_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.MILK_QUANTITY;
        outputRecipe[ this.MILK_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.MILLILITERS;
        
        outputRecipe[ this.VEGETAL_OIL_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.VEGETAL_OIL;
        outputRecipe[ this.VEGETAL_OIL_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.VEGETAL_OIL_QUANTITY;
        outputRecipe[ this.VEGETAL_OIL_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.MILLILITERS;
        
        return outputRecipe;
    }
}
