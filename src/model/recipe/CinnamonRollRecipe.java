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
 * @author Jorge A. Cano
 */
public class CinnamonRollRecipe implements Recipe{
    private final int TOTAL_INGREDIENTS = 8;
    
    private final int BUTTER_QUANTITY = 180;
    private final int BUTTER_DESCRIPTION = 0;
    
    private final Fraction SUGAR_QUANTITY = new Fraction( 7, 2 );
    private final int SUGAR_DESCRIPTION = 1;
    
    private final Fraction YEAST_QUANTITY = new Fraction( 5, 2 );
    private final int YEAST_DESCRIPTION = 2;
    
    private final int EGGS_QUANTITY = 1;
    private final int EGGS_DESCRIPTION = 3;
    
    private final int VANILLA_QUANTITY = 1;
    private final int VANILLA_DESCRIPTION = 4;
    
    private final int SALT_QUANTITY = 2;
    private final int SALT_DESCRIPTION = 5;
    
    private final int FLOUR_QUANTITY = 750;
    private final int FLOUR_DESCRIPTION = 6;
    
    private final Fraction MILK_QUANTITY = new Fraction( 2, 3 );
    private final int MILK_DESCRIPTION = 7;
    
    
    @Override
    public Object[][] getIngredients() {
        
        Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][CinnamonRollRecipe.PROPERTIES];
        
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.BUTTER;
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.BUTTER_QUANTITY;
        outputRecipe[ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.SUGAR;
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.SUGAR_QUANTITY;
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TABLESPOON;
        
        outputRecipe[ this.YEAST_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.YEAST;
        outputRecipe[ this.YEAST_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.YEAST_QUANTITY;
        outputRecipe[ this.YEAST_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TEASPOON;
        
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.EGGS;
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.EGGS_QUANTITY;
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.PIECE;
        
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
                Units.TEASPOON;
        
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
                Units.CUP;
        
        return outputRecipe;
    }
}
