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
public class PaulaCheeseBisquetRecipe implements Recipe{
    private final int TOTAL_INGREDIENTS = 7;
    
    private final int BUTTER_QUANTITY = 90;
    private final int BUTTER_POSITION = 0;
    
    private final Fraction PEPPER_QUANTITY = new Fraction( 1, 4 );
    private final int PEPPER_POSITION = 1;
    
    private final int CHEDDAR_CHEESE_QUANTITY = 1;
    private final int CHEDDAR_CHEESE_POSITION = 2;
    
    private final int MONTERREY_JACK_CHEESE_QUANTITY = 1;
    private final int MONTERREY_JACK_CHEESE_POSITION = 3;
    
    private final Fraction SALT_QUANTITY = new Fraction( 1, 4 );
    private final int SALT_POSITION = 4;
    
    private final int FLOUR_QUANTITY = 4;
    private final int FLOUR_POSITION = 5;
    
    private final int MILK_QUANTITY = 50;
    private final int MILK_POSITION = 6;
    
    @Override
    public Object[][] getIngredients() {
        
        Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][3];
        
        outputRecipe[ this.BUTTER_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.BUTTER;
        outputRecipe[ this.BUTTER_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.BUTTER_QUANTITY;
        outputRecipe[ this.BUTTER_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.CHEDDAR_CHEESE_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.CHEDDAR_CHEESE;
        outputRecipe[ this.CHEDDAR_CHEESE_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.CHEDDAR_CHEESE_QUANTITY;
        outputRecipe[ this.CHEDDAR_CHEESE_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.CUP;
        
        outputRecipe[ this.MONTERREY_JACK_CHEESE_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.MONTERREY_JACK_CHEESE;
        outputRecipe[ this.MONTERREY_JACK_CHEESE_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.MONTERREY_JACK_CHEESE_QUANTITY;
        outputRecipe[ this.MONTERREY_JACK_CHEESE_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.CUP;
        
        outputRecipe[ this.PEPPER_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.PEPPER;
        outputRecipe[ this.PEPPER_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.PEPPER_QUANTITY;
        outputRecipe[ this.PEPPER_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.SMALL_SPOON;
        
        outputRecipe[ this.SALT_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.SALT;
        outputRecipe[ this.SALT_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.SALT_QUANTITY;
        outputRecipe[ this.SALT_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.SMALL_SPOON;
        
        outputRecipe[ this.FLOUR_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.FLOUR;
        outputRecipe[ this.FLOUR_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.FLOUR_QUANTITY;
        outputRecipe[ this.FLOUR_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.CUP;
        
        outputRecipe[ this.MILK_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.MILK;
        outputRecipe[ this.MILK_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.MILK_QUANTITY;
        outputRecipe[ this.MILK_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.MILLILITERS;
        
        return outputRecipe;
    }
}
