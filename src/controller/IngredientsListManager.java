package controller;

import java.awt.event.ActionEvent;
import view.IngredientsSheet;

public final class IngredientsListManager extends Controller {

    private String[][] ingredientList;
    private final IngredientsSheet VIEW;

    public IngredientsListManager(String[][] inputIngredientList) {
        this.ingredientList = inputIngredientList;
        this.VIEW = new IngredientsSheet();
        this.VIEW.setVisible(true);
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
            //chef.bake();
        } else if (isNotGoingToBake(eventSource)) {
            //this.scrapIngredientsList();
        }
    }

    private boolean isNotGoingToBake(Object eventSource) {
        return eventSource == this.VIEW.getCloseButton();
    }

    private boolean isBaking(Object eventSource) {
        return eventSource == this.VIEW.getBakeButton();
    }

}
