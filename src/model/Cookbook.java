package model;

import model.recipe.OrangeCakeRecipe;
import model.recipe.Recipe;

public class Cookbook {
    
    private static final Cookbook instance = new Cookbook();
    public static final int INGREDIENT_QUANTITY = 1;
    
    private final String ORANGECAKE = "Pastel de Naranja";
    
    private Cookbook(){}
    
    public static Cookbook getInstance(){
        return instance;
    }
    
    public Recipe getRecipe(String inputProductName){
        Recipe requestedRecipe =  null;
        switch(inputProductName){
            case ORANGECAKE:
                requestedRecipe = new OrangeCakeRecipe();
                break;
        }
        return requestedRecipe;
    }
    
}
