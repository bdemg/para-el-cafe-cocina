package model.recipe;

import model.Fraction;
import model.IngredientsList;

public class OrangeCakeRecipe implements Recipe{
    
    private final int TOTAL_INGREDIENTS = 7;
    
    private final int BUTTER_QUANTITY = 500;
    private final int BUTTER_DESCRIPTION = 0;
    
    private final int SUGAR_QUANTITY = 300;
    private final int SUGAR_DESCRIPTION = 1;
    
    private final int EGGS_QUANTITY = 4;
    private final int EGGS_DESCRIPTION = 2;
    
    private final int BAKING_POWDER_QUANTITY = 1;
    private final int BAKING_POWDER_DESCRIPTION = 3;
    
    private final Fraction ORANGE_JUICE_QUANTITY = new Fraction ( 1, 2 );
    private final int ORANGE_JUICE_DESCRIPTION = 4;
    
    private final Fraction ORANGE_ZEST_QUANTITY = new Fraction ( 3, 2 );
    private final int ORANGE_ZEST_DESCRIPTION = 5;
    
    private final int FLOUR_QUANTITY = 400;
    private final int FLOUR_DESCRIPTION = 6;

    @Override
    public Object[][] getIngredients() {
        Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][OrangeCakeRecipe.PROPERTIES];
        
        outputRecipe [ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Ingredients.BUTTER;
        outputRecipe [ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] =
                this.BUTTER_QUANTITY;
        outputRecipe [ this.BUTTER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Units.GRAM;
        
        outputRecipe [ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Ingredients.SUGAR;
        outputRecipe [ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] =
                this.SUGAR_QUANTITY;
        outputRecipe [ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Units.GRAM;
        
        outputRecipe [ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Ingredients.EGGS;
        outputRecipe [ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] =
                this.EGGS_QUANTITY;
        outputRecipe [ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Units.PIECE;
        
        outputRecipe [ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Ingredients.BAKING_POWDER;
        outputRecipe [ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] =
                this.BAKING_POWDER_QUANTITY;
        outputRecipe [ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Units.TABLESPOON;
        
        outputRecipe [ this.ORANGE_JUICE_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Ingredients.ORANGE_JUICE;
        outputRecipe [ this.ORANGE_JUICE_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] =
                this.ORANGE_JUICE_QUANTITY;
        outputRecipe [ this.ORANGE_JUICE_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Units.CUP;
        
        outputRecipe [ this.ORANGE_ZEST_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Ingredients.ORANGE_ZEST;
        outputRecipe [ this.ORANGE_ZEST_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] =
                this.ORANGE_ZEST_QUANTITY;
        outputRecipe [ this.ORANGE_ZEST_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Units.TABLESPOON;
        
        outputRecipe [ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Ingredients.FLOUR;
        outputRecipe [ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] =
                this.FLOUR_QUANTITY;
        outputRecipe [ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] =
                Units.GRAM;
        
        return outputRecipe;
    }
    
}
