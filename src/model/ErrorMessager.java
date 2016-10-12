package model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio Soto
 */
public class ErrorMessager {
    
    private static final ErrorMessager errorMessager = new ErrorMessager();
    
    public final String INPUT_PASSWORD_ERROR = "Contraseña inválida.";
    public final String FILE_ERROR = "No se encontró el archivo. Consulte con el Ingeniero.";
    public final String SECURITY_QUESTION_ERROR = "Respuesta incorrecta.";
    
    private final String ERROR_TITLE = "¡Error!";
    
    private ErrorMessager(){
        ;
    }
    
    public static ErrorMessager callErrorMessager(){
        
        return errorMessager;
    }
    
    public void showErrorMessage( String errorMessage ){
        
        JFrame errorFrame = new JFrame();
        JOptionPane.showMessageDialog(
            errorFrame,
            errorMessage,
            this.ERROR_TITLE,
            JOptionPane.ERROR_MESSAGE
        );
    }
    
}
