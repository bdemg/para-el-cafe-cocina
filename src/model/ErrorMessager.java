package model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio Soto
 */
public class ErrorMessager {
    
    private static final ErrorMessager instance = new ErrorMessager();
    
    public final String INPUT_PASSWORD_ERROR = "Contraseña inválida.";
    public final String FILE_ERROR = "No se encontró el archivo. Consulte con el Ingeniero.";
    public final String SECURITY_QUESTION_ERROR = "Respuesta incorrecta.";
    
    private ErrorMessager(){}
    
    public static ErrorMessager getInstance(){
        return instance;
    }
    
    public void showErrorMessage(String errorMessage){
        JFrame errorFrame = new JFrame();
        String errorTitle = "¡Error!";
        JOptionPane.showMessageDialog(errorFrame, errorMessage, errorTitle, JOptionPane.ERROR_MESSAGE);
    }
    
}
