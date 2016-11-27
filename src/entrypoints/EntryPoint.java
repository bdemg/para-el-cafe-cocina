package entrypoints;

import controller.AccessManager;
import javax.swing.UIManager;
import view.OrdersBoard;

/**
 * The starting point of the application.
 * @author Antonio Soto
 */
public class EntryPoint {

    public static void main(String[] args) {
        
        setSystemLookAndFeel();
        AccessManager.callAccessManager();
    }

    
    //set the way the entire program's UI is going to look like
    private static void setSystemLookAndFeel() {
        try {
            
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrdersBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdersBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdersBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdersBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
}
