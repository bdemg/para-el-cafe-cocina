package controller;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.ConfirmationMessager;
import view.IngredientsSheet;
import model.IngredientsList;
import model.Order;

public final class IngredientsListManager extends Controller {

    private final IngredientsSheet ingredientsSheet;
    private final Order order;
    
    private final String INGREDIENTS_TITLE = "Lista de ingredientes para ";
    private final String BLANKSPACE = " "; 

    public IngredientsListManager(IngredientsList inputIngredientList, Order inputOrder) {
        this.ingredientsSheet = new IngredientsSheet();
        this.ingredientsSheet.setVisible(true);
        this.ingredientsSheet.setLocationRelativeTo(null);
        this.ingredientsSheet.setResizable(false);
        this.ingredientsSheet.setIngredientsList(inputIngredientList);
        this.ingredientsSheet.setTitle(this.INGREDIENTS_TITLE + inputOrder.getProductQuantity() +
                this.BLANKSPACE + inputOrder.getProductName());
        
        this.order = inputOrder;
        
        this.addActionListeners();
    }

    @Override
    protected void addActionListeners() {
        this.ingredientsSheet.getCloseButton().addActionListener(this);
        this.ingredientsSheet.getBakeButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object eventSource = event.getSource();
        if (isBaking(eventSource)) {
            this.orderCompleted();
            
        } else if (isNotGoingToBake(eventSource)) {
            this.scrapIngredientsList();
        }
    }

    private boolean isNotGoingToBake(Object eventSource) {
        return eventSource == this.ingredientsSheet.getCloseButton();
    }

    private boolean isBaking(Object eventSource) {
        return eventSource == this.ingredientsSheet.getBakeButton();
    }
    
    private void scrapIngredientsList(){
        this.ingredientsSheet.dispose();
    }
    
    private void orderCompleted(){
        //se utiliza el DAO para actualizar la BD
        //implementar cuando se tenga el DAO
        if( this.tellConfirmationMessagerToAskForConfirmation( 
                ConfirmationMessager.CONFIRM_BAKE_ORDER ) ){
        
        OrdersManager.callOrdersManager().markOrderAsBaked( this.order.getFolio() );
        }else{
            
        this.ingredientsSheet.dispose();
        }
    }
    
    private boolean tellConfirmationMessagerToAskForConfirmation( String input_ConfirmationMessage ){
        
        ConfirmationMessager confirmationMessager = ConfirmationMessager.callConfirmationMessager();
        return confirmationMessager.askForConfirmation( input_ConfirmationMessage );
    }

}
