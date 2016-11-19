package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author (c) Copyright 2016 José A. Soto. All Rights Reserved.
 */
public class OrdersDAO extends DAO{
    
    private static final OrdersDAO ordersDAO = new OrdersDAO();
    
    private final String RETREIVE_ORDERS_QUERY = 
            "SELECT folio, product_name, quantity, date, isBaked FROM sales WHERE isBaked=false";
    private final String UPDATE_ISBAKED_QUERY = 
            "UPDATE sales SET isBaked=true WHERE folio=?";
    
    private final int FIRST_QUERY_VALUE = 1;
    
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
    
    private OrdersDAO(){
        
        super();
    }
    
    public static OrdersDAO getOrdersDAO(){
        
        return ordersDAO;
    }
    
    public Object[] retreiveNonBakedProducts(){
        
        try { 
            PreparedStatement queryStatement = (PreparedStatement)
                    super.connectionToDatabase.prepareStatement( this.RETREIVE_ORDERS_QUERY );
            
            ResultSet resultSet = queryStatement.executeQuery();
            
            Object[] nonBakedProducts = new String[resultSet.getMetaData().getColumnCount()];
            
            nonBakedProducts[ this.FOLIO_COLUMN ] = 
                    resultSet.getString( this.FOLIO_COLUMN_NAME );
            nonBakedProducts[ this.PRODUCTNAME_COLUMN ] = 
                    resultSet.getString( this.PRODUCTNAME_COLUMN_NAME );
            nonBakedProducts[ this.QUANTITY_COLUMN ] = 
                    resultSet.getInt( this.QUANTITY_COLUMN_NAME );
            
            Timestamp date = resultSet.getTimestamp( this.DATE_COLUMN_NAME );
            nonBakedProducts[ this.DATE_COLUMN ] = 
                    this.timestampToString( date );
            
            nonBakedProducts[ this.ISBAKED_COLUMN ] = 
                    resultSet.getBoolean( this.ISBAKED_COLUMN_NAME );
            
            return nonBakedProducts;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void updateProductBakedState( String input_Folio ){
        
        try {
            PreparedStatement queryStatement = (PreparedStatement)
                    super.connectionToDatabase.prepareStatement( this.UPDATE_ISBAKED_QUERY );
            queryStatement.setString( this.FIRST_QUERY_VALUE, input_Folio );
            
            queryStatement.executeQuery();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public String timestampToString(Timestamp input_Date){
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(input_Date.getTime());
        
        String output_Date = ""
                + calendar.get( Calendar.YEAR )+"/"
                + calendar.get( Calendar.MONTH )+"/"
                + calendar.get( Calendar.YEAR )+" "
                + calendar.get( Calendar.HOUR_OF_DAY )+":"
                + calendar.get( Calendar.MINUTE );
        return output_Date;
    }
    
}
