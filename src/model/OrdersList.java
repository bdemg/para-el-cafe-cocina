package model;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class OrdersList extends DefaultTableModel {
    
    public static final int FOLIO = 0;
    public static final int PRODUCT_NAME = 1;
    public static final int PRODUCT_QUANTITY = 2;
    public static final int DUE_DATE = 3;
    public static final int SELECTION = 4;
    
    private static final String[] COLUMN_TITLES = {"Folio", "Producto", "Cantidad", "Fecha", "Seleccionar"};

    
    public OrdersList(int input_rowCount) {
        super(OrdersList.COLUMN_TITLES, input_rowCount);
    }
    
    
    public OrdersList(Object[][] orders){
        super(orders, OrdersList.COLUMN_TITLES);
    }

    
    //the diferent types of values that are can be written to the orders list
    @Override
    public Class<?> getColumnClass(int input_columnIndex) {
        
        Class columnClass = String.class;
        switch (input_columnIndex) {
            
            case OrdersList.FOLIO:
                columnClass = String.class;
                break;
            
            case OrdersList.PRODUCT_NAME:
                columnClass = String.class;
                break;
                
            case OrdersList.PRODUCT_QUANTITY:
                columnClass = Object.class;
                break;
                
            case OrdersList.DUE_DATE:
                columnClass = String.class;
                break;
                
            case OrdersList.SELECTION:
                columnClass = Boolean.class;
                break;
        }
        return columnClass;
    }

    
    //the selection is the only part of the orders list that the people in the kitchen can interact with
    @Override
    public boolean isCellEditable(int input_row, int input_column) {
        
        boolean isEditable = (input_column == OrdersList.SELECTION);
        return isEditable;
    }
    
    
    //
    @Override
    public void setValueAt(Object input_value, int input_row, int input_column) {
        
        boolean isCheckboxColumn = input_column == OrdersList.SELECTION;
        boolean isBooleanValue = input_value instanceof Boolean;

        if (isCheckboxColumn && isBooleanValue) {
            
            Vector rowData = (Vector) getDataVector().get(input_row);
            rowData.set(OrdersList.SELECTION, (boolean) input_value);
            fireTableCellUpdated(input_row, input_column);
        }
    }

}
