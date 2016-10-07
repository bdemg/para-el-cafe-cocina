/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jorge A. Cano
 */
public class Order {
    
    private final String productName;
    private final int productQuantity;
    private final String dueDate;

    
    public Order( 
            String inputProductName, 
            String inputDueDate, 
            int inputProductQuantity
    ) {
        
        this.productName = inputProductName;
        this.productQuantity = inputProductQuantity;
        this.dueDate = inputDueDate;
    }

    
    public String getProductName() {
        
        return productName;
    }

    
    public int getProductQuantity() {
        
        return productQuantity;
    }

    
    public String getDueDate() {
        
        return dueDate;
    }
    
}
