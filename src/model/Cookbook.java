package model;

import model.recipe.BrownieRecipe;
import model.recipe.CinnamonRollRecipe;
import model.recipe.ItalianMeringueRecipe;
import model.recipe.OrangeCakeRecipe;
import model.recipe.PaulaCheeseBisquetRecipe;
import model.recipe.PerfectCupCakeRecipe;
import model.recipe.Recipe;
import model.recipe.StrawberryCakeRecipe;

public class Cookbook {
    
    private static final Cookbook instance = new Cookbook();
    public static final int INGREDIENT_QUANTITY = 1;
    
    private final String ORANGE_CAKE = "Pastel de Naranja";
    private final String BROWNIE = "Brownies";
    private final String CINNAMONROLL = "Roles de Canela";
    private final String ITALIAN_MERINGUE = "Merengue Italiano";
    private final String PAULA_CHEESE_BISQUET = "Bisquet de Queso Paula";
    private final String PERFECT_CUPCAKE = "Cupcake perfecto";
    private final String STRABERRY_CAKE = "Pastel de Fresas";
            
    private Cookbook(){}
    
    public static Cookbook getInstance(){
        return instance;
    }
    
    public Recipe getRecipe(String inputProductName){
        Recipe requestedRecipe =  null;
        switch(inputProductName){
            case ORANGE_CAKE:
                requestedRecipe = new OrangeCakeRecipe();
                break;
                
            case BROWNIE:
                requestedRecipe = new BrownieRecipe();
                break;
                
            case CINNAMONROLL:
                requestedRecipe = new CinnamonRollRecipe();
                break;
                
            case ITALIAN_MERINGUE:
                requestedRecipe = new ItalianMeringueRecipe();
                break;
                
            case PAULA_CHEESE_BISQUET:
                requestedRecipe = new PaulaCheeseBisquetRecipe();
                break;
                
            case PERFECT_CUPCAKE:
                requestedRecipe = new PerfectCupCakeRecipe();
                break;
                
            case STRABERRY_CAKE:
                requestedRecipe = new StrawberryCakeRecipe();
                break;
        }
        return requestedRecipe;
    }
    
}
