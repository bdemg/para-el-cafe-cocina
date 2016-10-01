package model;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class OrdersList extends DefaultTableModel {
    
    public static final int PRODUCT_NAME = 0;
    public static final int PRODUCT_QUANTITY = 1;
    public static final int DUE_DATE = 2;
    public static final int SELECTION = 3;
    private static final String[] COLUMN_TITLES = {"Producto", "Cantidad", "Fecha", "Seleccionar"};

    public OrdersList(int inputRowCount) {
        super(OrdersList.COLUMN_TITLES, inputRowCount);
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
            case 3:
                columnClass = Boolean.class;
                break;
        }
        return columnClass;
    }

    @Override
    public boolean isCellEditable(int inputRow, int inputColumn) {
        boolean isEditable = (inputColumn == OrdersList.SELECTION);
        return isEditable;
    }
    
    @Override
    public void setValueAt(Object inputValue, int inputRow, int inputColumn) {
        boolean isCheckboxColumn = inputColumn == OrdersList.SELECTION;
        boolean isBooleanValue = inputValue instanceof Boolean;

        if (isCheckboxColumn && isBooleanValue) {
            Vector rowData = (Vector) getDataVector().get(inputRow);
            rowData.set(OrdersList.SELECTION, (boolean) inputValue);
            fireTableCellUpdated(inputRow, inputColumn);
        }
    }

}
