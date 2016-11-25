/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * This class represents a client's order
 * @author Jorge A. Cano
 */
public class Order {
    
    private final String folio;
    private final String productName;
    private final int productQuantity;
    private final String dueDate;

    
    public Order( 
            String input_folio,
            String input_productName, 
            String input_dueDate, 
            int input_productQuantity
    ) {
        
        this.folio = input_folio;
        this.productName = input_productName;
        this.productQuantity = input_productQuantity;
        this.dueDate = input_dueDate;
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

    
    public String getFolio() {
        return folio;
    }
    
}
