package model;

import javax.swing.table.DefaultTableModel;

public class IngredientsList extends DefaultTableModel{
    
    public static final int INGREDIENT_NAME = 0;
    public static final int INGREDIENT_QUANTITY = 1;
    public static final int INGREDIENT_UNIT = 2;
    
    private static final String[] COLUMN_TITLES = {"Ingredientes", "Cantidad", "Unidades"};
    
    public IngredientsList(int inputRowCount){
        super(IngredientsList.COLUMN_TITLES, inputRowCount);
    }

    public IngredientsList(Object[][] data) {
        super(data, IngredientsList.COLUMN_TITLES);
    }
    
    
    
    @Override
    public Class<?> getColumnClass(int inputColumnIndex) {
        
        Class columnClass = String.class;
        switch (inputColumnIndex) {
            
            case IngredientsList.INGREDIENT_NAME:
                columnClass = String.class;
                break;
                
            case IngredientsList.INGREDIENT_QUANTITY:
                columnClass = Integer.class;
                break;
                
            case IngredientsList.INGREDIENT_UNIT:
                columnClass = String.class;
                break;
                
            default:
                break;
        }
        return columnClass;
    }
}
