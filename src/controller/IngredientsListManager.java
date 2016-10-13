package controller;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.WarningMessager;
import view.IngredientsSheet;
import model.IngredientsList;

public final class IngredientsListManager extends Controller {

    private final IngredientsSheet VIEW;

    public IngredientsListManager(IngredientsList inputIngredientList) {
        this.VIEW = new IngredientsSheet();
        this.VIEW.setVisible(true);
        this.VIEW.setIngredientsList(inputIngredientList);
        
        this.addActionListeners();
    }

    @Override
    protected void addActionListeners() {
        this.VIEW.getCloseButton().addActionListener(this);
        this.VIEW.getBakeButton().addActionListener(this);
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
        return eventSource == this.VIEW.getCloseButton();
    }

    private boolean isBaking(Object eventSource) {
        return eventSource == this.VIEW.getBakeButton();
    }
    
    private void scrapIngredientsList(){
        this.VIEW.dispose();
    }
    
    private void orderCompleted(){
        //se utiliza el DAO para actualizar la BD
        //implementar cuando se tenga el DAO
        WarningMessager warningMessager = WarningMessager.callWarningMessager();
        warningMessager.showWarningMessage(warningMessager.CONFIRM_BAKING_ORDER);
        this.VIEW.dispose();
    }

}
