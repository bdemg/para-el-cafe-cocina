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
public final class OrdersManager extends Controller {
    
    private final OrdersBoard ordersBoard;
    
    
    public OrdersManager() {
        
        this.ordersBoard = new OrdersBoard();
        this.ordersBoard.setVisible( true );
        this.ordersBoard.setResizable(false);
        this.ordersBoard.setLocationRelativeTo(null);
        
        this.addActionListeners();
        
        Object[][] orders = this.retriveOrders();
        this.ordersBoard.setOrdersList(new OrdersList(orders));
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
        
        OrdersList ordersList = this.ordersBoard.getOrdersList();
        
        for( int ordersCount = 0; ordersCount < ordersList.getRowCount(); ordersCount++ ){
            
            boolean isOrderSelected = (boolean) ordersList.getValueAt( ordersCount,
                    OrdersList.SELECTION );
            if( isOrderSelected ){
                
                String productName = (String) ordersList.getValueAt( ordersCount,
                    OrdersList.PRODUCT_NAME );
                int productQuantity = (int) ordersList.getValueAt( ordersCount,
                    OrdersList.PRODUCT_QUANTITY );
                String dueDate = (String) ordersList.getValueAt( ordersCount,
                    OrdersList.DUE_DATE );
                Order selectedOrder = new Order( 
                    productName,
                    dueDate,
                    productQuantity 
                );
                
                Chef.callChef().createIngredientsList( selectedOrder );
            }
        }
    }

    
    //Actualmente con valores prueba, eventualmente se comunicará con un DAO
    
    private Object[][] retriveOrders() {
        
        Object[][] orders = new Object[4][3];
        
        orders[0][0] = "Brownie";
        orders[0][1] = 4;
        orders[0][2] = "12/10/2016 16:75";
        
        orders[1][0] = "Rol de canela";
        orders[1][1] = 6;
        orders[1][2] = "12/10/2016 16:75";
        
        orders[2][0] = "Pay de limón";
        orders[2][1] = 1;
        orders[2][2] = "12/10/2016 16:75";
        
        return orders;
    }

    
}
