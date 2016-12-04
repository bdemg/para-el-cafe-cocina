package model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class represents a messager that sends error notifications.
 * @author (c) Copyright 2016 José A. Soto. All Rights Reserved.
 */
public class ErrorMessager {
    
    private static final ErrorMessager errorMessager = new ErrorMessager();
    
    // Types of errors.
    public static final String INPUT_PASSWORD_ERROR = 
         "Contraseña inválida.";
    public static final String FILE_ERROR = 
        "No se encontró el archivo. Consulte con el Ingeniero.";
    public static final String SECURITY_QUESTION_ERROR = 
        "Respuesta incorrecta.";
    public static final String DATABASE_ERROR = 
        "No se puede conectar con la base de datos, verifique que esté encendida."
        + " Si el problema persiste, consulte con el Ingeniero.";
    
    private final String ERROR_TITLE = "¡Error!";
    
    private ErrorMessager(){
        ;
    }
    
    public static ErrorMessager callErrorMessager(){
        
        return ErrorMessager.errorMessager;
    }
    
    // Shows an error message to the user.
    public void showErrorMessage( String input_ErrorMessage ){
        
        JFrame errorFrame = new JFrame();
        JOptionPane.showMessageDialog(
            errorFrame,
            input_ErrorMessage,
            this.ERROR_TITLE,
            JOptionPane.ERROR_MESSAGE
        );
    }
    
}
