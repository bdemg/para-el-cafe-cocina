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

public class CheeseCakeRecipe implements Recipe{
    
    private final int TOTAL_INGREDIENTS = 6;
    
    private final int MARIA_COOKIES_QUANTITY = 1;
    private final int MARIA_COOKIES_DESCRIPTION = 0;
    
    private final int MARGARINE_QUANTITY = 90;
    private final int MARGARINE_DESCRIPTION = 1;
    
    private final int EGGS_QUANTITY = 4;
    private final int EGGS_DESCRIPTION = 2;
    
    private final int CONDENSED_MILK_QUANTITY = 1;
    private final int CONDENSED_MILK_DESCRIPTION = 3;
    
    private final Fraction BAKING_POWDER_QUANTITY = new Fraction( 1, 2 );
    private final int BAKING_POWDER_DESCRIPTION = 4;
    
    private final int CREAM_CHEESE_QUANTITY = 190;
    private final int CREAM_CHEESE_DESCRIPTION = 5;

    @Override
    public Object[][] getIngredients() {
        Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][CheeseCakeRecipe.PROPERTIES];
        
        outputRecipe[ this.MARIA_COOKIES_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.MARIA_COOKIES;
        outputRecipe[ this.MARIA_COOKIES_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.MARIA_COOKIES_QUANTITY;
        outputRecipe[ this.MARIA_COOKIES_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.PACK;
        
        outputRecipe[ this.MARGARINE_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.MARGARINE;
        outputRecipe[ this.MARGARINE_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.MARGARINE_QUANTITY;
        outputRecipe[ this.MARGARINE_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.EGGS;
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.EGGS_QUANTITY;
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.PIECE;
        
        outputRecipe[ this.CONDENSED_MILK_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.CONDENSED_MILK;
        outputRecipe[ this.CONDENSED_MILK_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.CONDENSED_MILK_QUANTITY;
        outputRecipe[ this.CONDENSED_MILK_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.CAN;
        
        outputRecipe[ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.BAKING_POWDER;
        outputRecipe[ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.BAKING_POWDER_QUANTITY;
        outputRecipe[ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TEASPOON;
        
        outputRecipe[ this.CREAM_CHEESE_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.CREAM_CHEESE;
        outputRecipe[ this.CREAM_CHEESE_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.CREAM_CHEESE_QUANTITY;
        outputRecipe[ this.CREAM_CHEESE_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        return outputRecipe;
    }

}
