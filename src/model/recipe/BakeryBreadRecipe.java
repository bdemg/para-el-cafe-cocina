package model.recipe;

import model.Fraction;
import model.IngredientsList;

/**
 * 
 * @author Evan-Ian-Ray
 */
public class BakeryBreadRecipe implements Recipe{

    private final int TOTAL_INGREDIENTS = 8;
    
    private final int EGGS_QUANTITY = 3;
    private final int EGGS_DESCRIPTION = 0;
    
    private final int SUGAR_QUANTITY = 188;
    private final int SUGAR_DESCRIPTION = 1;
    
    private final int FLOUR_QUANTITY = 750;
    private final int FLOUR_DESCRIPTION = 2;
    
    private final int STABILIZER_QUANTITY = 1;
    private final int STABILIZER_DESCRIPTION = 3;
    
    private final int YEAST_QUANTITY = 3;
    private final int YEAST_DESCRIPTION = 4;
    
    private final int WATER_QUANTITY = 200;
    private final int WATER_DESCRIPTION = 5;
    
    private final Fraction MARGARINE_QUANTITY = new Fraction ( 225, 2 );
    private final int MARGARINE_DESCRIPTION = 6;
    
    private final int VEGETAL_OIL_QUANTITY = 1;
    private final int VEGETAL_OIL_DESCRIPTION = 7;
    
    @Override
    public Object[][] getIngredients() {
       Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][BakeryBreadRecipe.PROPERTIES];
        
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.EGGS;
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.EGGS_QUANTITY;
        outputRecipe[ this.EGGS_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.PIECE;
        
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.SUGAR;
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.SUGAR_QUANTITY;
        outputRecipe[ this.SUGAR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.FLOUR;
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.FLOUR_QUANTITY;
        outputRecipe[ this.FLOUR_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.STABILIZER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.STABILIZER;
        outputRecipe[ this.STABILIZER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.STABILIZER_QUANTITY;
        outputRecipe[ this.STABILIZER_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TABLESPOON;
        
        outputRecipe[ this.YEAST_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.YEAST;
        outputRecipe[ this.YEAST_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.YEAST_QUANTITY;
        outputRecipe[ this.YEAST_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TABLESPOON;
        
        outputRecipe[ this.WATER_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.WATER;
        outputRecipe[ this.WATER_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.WATER_QUANTITY;
        outputRecipe[ this.WATER_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.MILLILITERS;
        
        outputRecipe[ this.MARGARINE_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.MARGARINE;
        outputRecipe[ this.MARGARINE_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.MARGARINE_QUANTITY;
        outputRecipe[ this.MARGARINE_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.VEGETAL_OIL_DESCRIPTION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.VEGETAL_OIL;
        outputRecipe[ this.VEGETAL_OIL_DESCRIPTION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.VEGETAL_OIL_QUANTITY;
        outputRecipe[ this.VEGETAL_OIL_DESCRIPTION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.TEASPOON;
        
        return outputRecipe;
    }
    
}
