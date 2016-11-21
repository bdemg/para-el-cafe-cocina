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

public class ConchaTopingRecipe implements Recipe{
    
    private final int TOTAL_INGREDIENTS = 3;
    
    private final int VEGETAL_LARD_QUANTITY = 300;
    private final int VEGETAL_LARD_DESCRIPTION = 0;
    
    private final int GLASS_SUGAR_QUANTITY = 300;
    private final int GLASS_SUGAR_DESCRIPTION = 1;
    
    private final int FLOUR_QUANTITY = 300;
    private final int FLOUR_DESCRIPTION = 2;

    @Override
    public Object[][] getIngredients() {
       Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][ConchaTopingRecipe.PROPERTIES];
        
        outputRecipe[ this.VEGETAL_LARD_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.VEGETAL_LARD;
        outputRecipe[ this.VEGETAL_LARD_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.VEGETAL_LARD_QUANTITY;
        outputRecipe[ this.VEGETAL_LARD_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.GLASS_SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.GLASS_SUGAR;
        outputRecipe[ this.GLASS_SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.GLASS_SUGAR_QUANTITY;
        outputRecipe[ this.GLASS_SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
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
