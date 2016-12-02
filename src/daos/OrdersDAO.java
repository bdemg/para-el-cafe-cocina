package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class can access and modify the orders information.
 * @author (c) Copyright 2016 José A. Soto. All Rights Reserved.
 */
public class OrdersDAO extends DatabaseDAO{
    
    private static OrdersDAO ordersDAO;
    
    private final String RETREIVE_ORDERS_QUERY = 
            "SELECT folio, product_name, quantity, date, isBaked FROM sales WHERE isBaked=false";
    private final String UPDATE_ISBAKED_QUERY = 
            "UPDATE sales SET isBaked=true WHERE folio=?";
    
    private final int FIRST_QUERY_VALUE = 1;
    
	// Orders table columns
    private final int FOLIO_COLUMN = 0;
    private final int PRODUCTNAME_COLUMN = 1;
    private final int QUANTITY_COLUMN = 2;
    private final int DATE_COLUMN = 3;
    private final int ISBAKED_COLUMN = 4;
    
    private final String FOLIO_COLUMN_NAME = "folio";
    private final String PRODUCTNAME_COLUMN_NAME = "product_name";
    private final String QUANTITY_COLUMN_NAME = "quantity";
    private final String DATE_COLUMN_NAME = "date";
    private final String ISBAKED_COLUMN_NAME = "isBaked";
    
    private OrdersDAO() throws SQLException{
        
        super();
    }
    
    public static OrdersDAO getOrdersDAO() throws SQLException{
        
        if(ordersDAO == null){
            ordersDAO = new OrdersDAO();
        }
        
        return ordersDAO;
    }
    
	// Gets the list of orders that are not yet baked.
    public Object[][] retreiveNonBakedOrders() throws SQLException{
        
        PreparedStatement queryStatement = (PreparedStatement)
                super.connectionToDatabase.prepareStatement( this.RETREIVE_ORDERS_QUERY );
            
        ResultSet resultSet = queryStatement.executeQuery();
            
        return this.retreivedOrdersToArray( resultSet );
    }
    
	// Gets the complete list of orders.
    private Object[][] retreivedOrdersToArray(ResultSet resultSet) throws SQLException{
        
        int maxRows = 0;
        if(resultSet.last()){
            maxRows = resultSet.getRow();
            resultSet.beforeFirst();
        }
            
        int maxColumns = resultSet.getMetaData().getColumnCount();
        Object[][] nonBakedOrders = new Object[maxRows][maxColumns];
        int row = 0;
            
        while(resultSet.next()){
                    
            nonBakedOrders[ row ][ this.FOLIO_COLUMN ] = 
                    resultSet.getString( this.FOLIO_COLUMN_NAME );
                    
            nonBakedOrders[ row ][ this.PRODUCTNAME_COLUMN ] = 
                    resultSet.getString( this.PRODUCTNAME_COLUMN_NAME );
                    
            nonBakedOrders[ row ][ this.QUANTITY_COLUMN ] = 
                    resultSet.getInt( this.QUANTITY_COLUMN_NAME );
            
            nonBakedOrders[ row ][ this.DATE_COLUMN ] = 
                    new RevisedTimestamp(
                            resultSet.getTimestamp( this.DATE_COLUMN_NAME )
                    ).toString();
                    
            nonBakedOrders[ row ][ this.ISBAKED_COLUMN ] = 
                    resultSet.getBoolean( this.ISBAKED_COLUMN_NAME );
                    
            row++;
        }
        
        return nonBakedOrders;
    }
    
	// Sets the product baked state to true.
    public void updateProductBakedState( String input_Folio ) throws SQLException{
        
        PreparedStatement queryStatement = (PreparedStatement)
                super.connectionToDatabase.prepareStatement( this.UPDATE_ISBAKED_QUERY );
        queryStatement.setString( this.FIRST_QUERY_VALUE, input_Folio );
            
        queryStatement.execute();
    }
    
}
