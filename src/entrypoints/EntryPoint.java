package entrypoints;

import controller.AccessManager;
import javax.swing.UIManager;
import view.OrdersBoard;

/**
 *
 * @author Antonio Soto
 */
public class EntryPoint {

    public static void main(String[] args) {
        
        setSystemLookAndFeel();
        AccessManager accessManager = new AccessManager();
    }

    
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
