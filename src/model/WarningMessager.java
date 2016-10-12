package model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WarningMessager {
    
    private static final WarningMessager warningMessager = new WarningMessager();
    
    public final String CONFIRM_BAKING_ORDER = "¿Desea hornear esta receta?";
    
    private final String WARNING_TITLE = "¡Advertencia!";
    
    private WarningMessager(){
        ;
    }
    
    public static WarningMessager callWarningMessager(){
        return warningMessager;
    }
    
    public void showWarningMessage( String warningMessage ){
        
        JFrame warningFrame = new JFrame();
        JOptionPane.showMessageDialog(
            warningFrame,
            warningMessage,
            this.WARNING_TITLE,
            JOptionPane.WARNING_MESSAGE
        );
    }
}
