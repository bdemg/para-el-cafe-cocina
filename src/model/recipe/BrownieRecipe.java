package model.recipe;

import model.IngredientsList;

public class BrownieRecipe implements Recipe{
    
    private final int TOTAL_INGREDIENTS = 8;
    
    private final int BUTTER_QUANTITY = 300;
    private final int BUTTER_POSITION = 0;
    
    private final int SUGAR_QUANTITY = 350;
    private final int SUGAR_POSITION = 1;
    
    private final int CHOCOLATE_QUANTITY = 400;
    private final int CHOCOLATE_POSITION = 2;
    
    private final int EGGS_QUANTITY = 5;
    private final int EGGS_POSITION = 3;
    
    private final int VANILLA_QUANTITY = 1;
    private final int VANILLA_POSITION = 4;
    
    private final int SALT_QUANTITY = 1;
    private final int SALT_POSITION = 5;
    
    private final int FLOUR_QUANTITY = 150;
    private final int FLOUR_POSITION = 6;
    
    private final int NUTS_QUANTITY = 100;
    private final int NUTS_POSITION = 7;
    
    
    @Override
    public Object[][] getIngredients() {
        
        Object[][] outputRecipe = new Object[this.TOTAL_INGREDIENTS][3];
        
        outputRecipe[ this.BUTTER_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.BUTTER;
        outputRecipe[ this.BUTTER_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.BUTTER_QUANTITY;
        outputRecipe[ this.BUTTER_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.SUGAR_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.SUGAR;
        outputRecipe[ this.SUGAR_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.SUGAR_QUANTITY;
        outputRecipe[ this.SUGAR_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.CHOCOLATE_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.CHOCOLATE;
        outputRecipe[ this.CHOCOLATE_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.CHOCOLATE_QUANTITY;
        outputRecipe[ this.CHOCOLATE_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.EGGS_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.EGGS;
        outputRecipe[ this.EGGS_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.EGGS_QUANTITY;
        outputRecipe[ this.EGGS_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.PIECE;
        
        outputRecipe[ this.VANILLA_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.VANILLA;
        outputRecipe[ this.VANILLA_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.VANILLA_QUANTITY;
        outputRecipe[ this.VANILLA_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.SMALL_SPOON;
        
        outputRecipe[ this.SALT_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.SALT;
        outputRecipe[ this.SALT_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.SALT_QUANTITY;
        outputRecipe[ this.SALT_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.PIZCA;
        
        outputRecipe[ this.FLOUR_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.FLOUR;
        outputRecipe[ this.FLOUR_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.FLOUR_QUANTITY;
        outputRecipe[ this.FLOUR_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        outputRecipe[ this.NUTS_POSITION ][ IngredientsList.INGREDIENT_NAME ] = 
                Ingredients.NUTS;
        outputRecipe[ this.NUTS_POSITION ][ IngredientsList.INGREDIENT_QUANTITY ] = 
                this.NUTS_QUANTITY;
        outputRecipe[ this.NUTS_POSITION ][ IngredientsList.INGREDIENT_UNIT ] = 
                Units.GRAM;
        
        return outputRecipe;
    }
    
}
