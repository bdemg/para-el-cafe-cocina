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

public class NutPastryRecipe implements Recipe{

    private final int TOTAL_INGREDIENTS = 3;
    
    private final int BUTTER_QUANTITY = 125;
    private final int BUTTER_DESCRIPTION = 0;
    
    private final int NUTS_QUANTITY = 125;
    private final int NUTS_DESCRIPTION = 1;
    
    private final int FLOUR_QUANTITY = 125;
    private final int FLOUR_DESCRIPTION = 2;

    @Override
    public Object[][] getIngredients() {
        Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][NutPastryRecipe.PROPERTIES];
        
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.BUTTER;
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.BUTTER_QUANTITY;
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.NUTS_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.NUTS;
        outputRecipe[ this.NUTS_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.NUTS_QUANTITY;
        outputRecipe[ this.NUTS_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.FLOUR;
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.FLOUR_QUANTITY;
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        return outputRecipe;
        }
    
}
