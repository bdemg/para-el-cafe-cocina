package model;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class OrdersList extends DefaultTableModel {
    
    public static final int PRODUCT_NAME = 0;
    public static final int PRODUCT_QUANTITY = 1;
    public static final int DUE_DATE = 2;
    public static final int SELECTION = 3;
    private static final String[] COLUMN_TITLES = {"Producto", "Cantidad", "Fecha", "Seleccionar"};

    public OrdersList(int input_rowCount) {
        super(OrdersList.COLUMN_TITLES, input_rowCount);
    }
    
    public OrdersList(Object[][] orders){
        super(orders, OrdersList.COLUMN_TITLES);
    }

    @Override
    public Class<?> getColumnClass(int input_columnIndex) {
        
        Class columnClass = String.class;
        switch (input_columnIndex) {
            
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

    @Override
    public boolean isCellEditable(int input_row, int input_column) {
        
        boolean isEditable = (input_column == OrdersList.SELECTION);
        return isEditable;
    }
    
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
