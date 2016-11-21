package model;

import model.recipe.BrownieRecipe;
import model.recipe.CinnamonRollRecipe;
import model.recipe.ItalianMeringueRecipe;
import model.recipe.OrangeCakeRecipe;
import model.recipe.PaulaCheeseBisquetRecipe;
import model.recipe.PerfectCupCakeRecipe;
import model.recipe.Recipe;
import model.recipe.BakeryBreadRecipe;
import model.recipe.ButterCreamRecipe;
import model.recipe.CheeseCakeRecipe;
import model.recipe.ConchaTopingRecipe;
import model.recipe.GlassedCheeseRecipe;
import model.recipe.LemonPieRecipe;
import model.recipe.NutPastryRecipe;
import model.recipe.RedVelvetCakeRecipe;

public class Cookbook {
    
    private static final Cookbook instance = new Cookbook();
    public static final int INGREDIENT_QUANTITY = 1;
    
    private final String ORANGE_CAKE = "Pastel de Naranja";
    private final String BROWNIE = "Brownies";
    private final String CINNAMONROLL = "Roles de Canela";
    private final String ITALIAN_MERINGUE = "Merengue Italiano";
    private final String PAULA_CHEESE_BISQUET = "Bisquet de Queso Paula";
    private final String PERFECT_CUPCAKE = "Cupcake perfecto";
    private final String BUTTER_CREAM = "Crema de Mantequilla";
    private final String RED_VELVET_CAKE = "Pastel de Terciopelo Rojo";
    private final String LEMON_PIE = "Pay de Limón";
    private final String NUT_PASTRY = "Bolitas de Nuez";
    private final String GLASSED_CHEESE = "Glaseado de queso";
    private final String CHEESECAKE = "Pay de Queso";
    private final String BAKERY_BREAD = "Bolillo";
    private final String CONCHA_TOPPING = "Concha";
            
    private Cookbook(){
        ;
    }
    
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
                
            case BUTTER_CREAM:
                requestedRecipe = new ButterCreamRecipe();
                break;
                
            case RED_VELVET_CAKE:
                requestedRecipe = new RedVelvetCakeRecipe();
                break;
                
            case LEMON_PIE:
                requestedRecipe = new LemonPieRecipe();
                break;
                
            case NUT_PASTRY:
                requestedRecipe = new NutPastryRecipe();
                break;
                
            case GLASSED_CHEESE:
                requestedRecipe = new GlassedCheeseRecipe();
                break;
                
            case CHEESECAKE:
                requestedRecipe = new CheeseCakeRecipe();
                break;
                
            case BAKERY_BREAD:
                requestedRecipe = new BakeryBreadRecipe();
                break;
                
            case CONCHA_TOPPING:
                requestedRecipe = new ConchaTopingRecipe();
                break;
        }
        return requestedRecipe;
    }
    
}
