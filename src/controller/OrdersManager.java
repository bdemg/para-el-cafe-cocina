/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.OrdersDAO;
import java.awt.event.ActionEvent;
import model.Chef;
import model.Order;
import model.OrdersList;
import view.OrdersBoard;

/**
 *
 * @author jorge
 */
public final class OrdersManager extends Controller {
    
    private final OrdersBoard ordersBoard;
    private static final OrdersManager ordersManager = new OrdersManager();
    
    public static OrdersManager callOrdersManager(){
        
        return OrdersManager.ordersManager;
    }
    
    private OrdersManager() {
        
        this.ordersBoard = new OrdersBoard();
        this.setupOrdersBoard();
        
        this.addActionListeners();
        
        this.putUpNonBakedOrdersInBoard();
    }
    
    
    private void setupOrdersBoard(){
        this.ordersBoard.setVisible( true );
        this.ordersBoard.setResizable( false );
        this.ordersBoard.setLocationRelativeTo( null );
    }
    
    
    @Override
    public void actionPerformed( ActionEvent input_actionEvent ) {
        
        Object eventSource = input_actionEvent.getSource();
        
        if( this.isSelectingOrders( eventSource ) ){
            this.selectOrdersToBake();
        }else if( this.isRequestingOrders( eventSource ) ){
            this.putUpNonBakedOrdersInBoard();
        }
    }
    
    
    private boolean isSelectingOrders( Object input_eventSource ) {
        
        return input_eventSource == this.ordersBoard.getShowIngredients();
    }
    
    
    private boolean isRequestingOrders( Object input_eventSource ) {
        
        return input_eventSource == this.ordersBoard.getRetriveOrders();
    }
    

    @Override
    protected void addActionListeners() {
        
        this.ordersBoard.getShowIngredients().addActionListener( this );
    }
    
    
    private void selectOrdersToBake() {
        
        OrdersList ordersList = this.ordersBoard.getOrdersList();
        
        for( int ordersCount = 0; ordersCount < ordersList.getRowCount(); ordersCount++ ){
            
            boolean isOrderSelected = (boolean) ordersList.getValueAt( ordersCount,
                    OrdersList.SELECTION );
            if( isOrderSelected ){
                
                Order selectedOrder = new Order( 
                    (String) ordersList.getValueAt( ordersCount, OrdersList.FOLIO ),
                    (String) ordersList.getValueAt( ordersCount, OrdersList.PRODUCT_NAME ),
                    (String) ordersList.getValueAt( ordersCount, OrdersList.DUE_DATE ),
                    (int) ordersList.getValueAt( ordersCount, OrdersList.PRODUCT_QUANTITY )
                );
                
                Chef.callChef().createIngredientsList( selectedOrder );
            }
        }
    }
    
    
    private void putUpNonBakedOrdersInBoard() {
        
        Object[][] UnbakedOrders = OrdersDAO.getOrdersDAO().retreiveNonBakedOrders(); 
        this.ordersBoard.setOrdersList( new OrdersList( UnbakedOrders ) );
    }
    
    public void markOrderAsBaked(String input_orderFolio){
        
        OrdersDAO.getOrdersDAO().updateProductBakedState(input_orderFolio);
        this.putUpNonBakedOrdersInBoard();
    }

    
}
