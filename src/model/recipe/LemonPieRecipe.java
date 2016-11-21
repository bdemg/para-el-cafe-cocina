/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.recipe;

import model.IngredientsList;
import model.Fraction;

/**
 *
 * @author Evan-Ian-Ray
 */

public class LemonPieRecipe implements Recipe{

    private final int TOTAL_INGREDIENTS = 6;
    
    private final int FLOUR_QUANTITY = 2;
    private final int FLOUR_DESCRIPTION = 0;
    
    private final Fraction BUTTER_QUANTITY = new Fraction ( 3, 4 );
    private final int BUTTER_DESCRIPTION = 1;
    
    private final int EGGS_QUANTITY = 750;
    private final int EGGS_DESCRIPTION = 2;
    
    private final int GLASS_SUGAR_QUANTITY = 1;
    private final int GLASS_SUGAR_DESCRIPTION = 3;
    
    private final int CONDENSED_MILK_QUANTITY = 3;
    private final int CONDENSED_MILK_DESCRIPTION = 4;
    
    private final int LEMON_JUICE_QUANTITY = 200;
    private final int LEMON_JUICE_DESCRIPTION = 5;

    @Override
    public Object[][] getIngredients() {
       Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][LemonPieRecipe.PROPERTIES];
        
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.FLOUR;
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.FLOUR_QUANTITY;
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.CUP;
        
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.BUTTER;
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.BUTTER_QUANTITY;
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.CUP;
        
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.EGGS;
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.EGGS_QUANTITY;
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.CUP;
        
        outputRecipe[ this.GLASS_SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.GLASS_SUGAR;
        outputRecipe[ this.GLASS_SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.GLASS_SUGAR_QUANTITY;
        outputRecipe[ this.GLASS_SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.CUP;
        
        outputRecipe[ this.CONDENSED_MILK_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.CONDENSED_MILK;
        outputRecipe[ this.CONDENSED_MILK_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.CONDENSED_MILK_QUANTITY;
        outputRecipe[ this.CONDENSED_MILK_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.CAN;
        
        outputRecipe[ this.LEMON_JUICE_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.LEMON_JUICE;
        outputRecipe[ this.LEMON_JUICE_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.LEMON_JUICE_QUANTITY;
        outputRecipe[ this.LEMON_JUICE_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.MILLILITERS;
        
      return outputRecipe;
    }
    
}
