package model;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class IngredientsList extends DefaultTableModel{
    
    public static final int INGREDIENT_NAME_COLUMN = 0;
    public static final int INGREDIENT_QUANTITY_COLUMN = 1;
    public static final int INGREDIENT_UNIT_COLUMN = 2;
    
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
            case 0:
                columnClass = String.class;
                break;
            case 1:
                columnClass = Integer.class;
                break;
            case 2:
                columnClass = String.class;
                break;
            default:
                break;
        }
        return columnClass;
    }
}
