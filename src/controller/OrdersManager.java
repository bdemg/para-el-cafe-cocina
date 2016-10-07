/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import model.Chef;
import model.Order;
import model.OrdersList;
import view.OrdersBoard;

/**
 *
 * @author jorge
 */
public final class OrdersManager extends Manager {
    
    private final OrdersBoard ordersBoard;
    
    
    public OrdersManager() {
        this.ordersBoard = new OrdersBoard();
        this.ordersBoard.setVisible( true );
        
        this.addActionListeners();
    }
    
    
    @Override
    public void actionPerformed( ActionEvent inputEvent ) {
        
        Object eventSource = inputEvent.getSource();
        
        if( this.isSelectingOrders( eventSource ) ){
            this.selectOrdersToBake();
        }
    }
    
    
    private boolean isSelectingOrders( Object inputEventSource ) {
        
        return inputEventSource == this.ordersBoard.getShowIngredientsButton();
    }
    

    @Override
    protected void addActionListeners() {
        
        this.ordersBoard.getShowIngredientsButton().addActionListener( this );
    }
    
    
    private void selectOrdersToBake() {
        
        OrdersList orders = this.ordersBoard.getOrdersList();
        
        for( int ordersCount = 0; ordersCount < orders.getRowCount(); ordersCount++ ){
            
            boolean isOrderSelected = (boolean) orders.getValueAt( ordersCount, OrdersList.SELECTION );
            if( isOrderSelected ){
                
                String productName = (String) orders.getValueAt( ordersCount, OrdersList.PRODUCT_NAME );
                int productQuantity = (int) orders.getValueAt( ordersCount, OrdersList.PRODUCT_QUANTITY );
                String dueDate = (String) orders.getValueAt( ordersCount, OrdersList.DUE_DATE );
                Order selectedOrder = new Order( productName, dueDate, productQuantity );
                
                Chef.getInstance().createIngredientsList( selectedOrder );
            }
        }
    }

    
}
