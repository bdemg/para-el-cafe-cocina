package model.recipe;

import model.Fraction;
import model.IngredientsList;

/**
 * 
 * @author Evan-Ian-Ray
 */
public class ItalianMeringueRecipe implements Recipe {
    
    private final int TOTAL_INGREDIENTS = 5;
    
    private final int EGG_YOLK_QUANTITY = 5;
    private final int EGG_YOLK_DESCRIPTION = 0;
    
    private final int SUGAR_QUANTITY = 300;
    private final int SUGAR_DESCRIPTION = 1;
    
    private final Fraction BAKING_POWDER_QUANTITY = new Fraction ( 1, 4 );
    private final int BAKING_POWDER_DESCRIPTION = 2;
    
    private final Fraction LEMON_JUICE_QUANTITY = new Fraction ( 1, 4 );
    private final int LEMON_JUICE_DESCRIPTION = 3;
    
    private final int WATER_QUANTITY = 4;
    private final int WATER_DESCRIPTION = 4;
    
    @Override
    public Object[][] getIngredients() {
        
        Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][ItalianMeringueRecipe.PROPERTIES];
        
        outputRecipe[ this.EGG_YOLK_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.EGG_YOLK;
        outputRecipe[ this.EGG_YOLK_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.EGG_YOLK_QUANTITY;
        outputRecipe[ this.EGG_YOLK_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.PIECE;
        
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.SUGAR;
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.SUGAR_QUANTITY;
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.BAKING_POWDER;
        outputRecipe[ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.BAKING_POWDER_QUANTITY;
        outputRecipe[ this.BAKING_POWDER_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TEASPOON;
        
        outputRecipe[ this.LEMON_JUICE_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.LEMON_JUICE;
        outputRecipe[ this.LEMON_JUICE_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.LEMON_JUICE_QUANTITY;
        outputRecipe[ this.LEMON_JUICE_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TEASPOON;
        
        outputRecipe[ this.WATER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.WATER;
        outputRecipe[ this.WATER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.WATER_QUANTITY;
        outputRecipe[ this.WATER_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TABLESPOON;
        
        return outputRecipe;
    }
    
}
