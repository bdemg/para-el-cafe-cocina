package controller;

import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import daos.PasswordFileDAO;
import model.ErrorMessager;
import model.PasswordCypher;
import model.Keywords;
import view.AccessDoor;

/**
 * This class is used to control who enters the access door.
 * @author (c) Copyright 2016 José A. Soto. All Rights Reserved.
 */
public class AccessManager extends Controller {
    
    private final AccessDoor accessDoor;
    
    // Security question info.
    private final String SECURITY_QUESTION = "¿Cuál es su nombre?";
    private final String SECURITY_QUESTION_TITLE = "Pregunta de Seguridad";
    private final String SECURITY_QUESTION_ANSWER = "nombre";
    
    public AccessManager() {
        
        this.accessDoor = new AccessDoor();
        
        this.addActionListeners();
    }
    
    @Override
    protected void addActionListeners() {
        
        this.accessDoor.getButtonEnterDoor().addActionListener(this);
        this.accessDoor.getButtonForgotPassword().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        Object eventSource = event.getSource();
        if ( isAccessingDoor ( eventSource ) ) {
            this.verifyKeyToCallOrdersManager();
            
        } else if ( isPasswordForgoten ( eventSource ) ) {
            String questionAnswer = this.askSecurityQuestion();
            this.verifyAnswer( questionAnswer );
        }
    }
    
    private boolean isAccessingDoor ( Object eventSource ) {
        
        return eventSource == this.accessDoor.getButtonEnterDoor();
    }
    
    private boolean isPasswordForgoten ( Object eventSource ) {
        
        return eventSource == this.accessDoor.getButtonForgotPassword();
    }
    
    // Goes to the Orders controller.
    private void verifyKeyToCallOrdersManager() {
  
        if ( isAccessKey() ) {
            this.closeAccessDoor();
            OrdersManager.callOrdersManager();
            
        } else {
            this.tellErrorMessagerToShowMessage( ErrorMessager.INPUT_PASSWORD_ERROR );
            this.cleanAccessDoorFields();
        }
    }
    
    // Closes the window.
    private void closeAccessDoor(){
        
        this.accessDoor.dispose();
    }
    
    // Resets the window.
    private void cleanAccessDoorFields(){
        
        this.accessDoor.getPasswordField().setText( Keywords.EMPTY );
    }
    
    // Checks if the entered password is correct. 
    private boolean isAccessKey() {
        
        try {
            String encryptedPassword =
                    PasswordFileDAO.getPasswordFileDAO().getStoredPassword();
            
            String storedPassword =
                    PasswordCypher.callPasswordCypher().decryptPassword(
                            encryptedPassword
                    );
            
            String enteredPassword = this.accessDoor.getPasswordField().getText();
            return ( storedPassword.equals( enteredPassword ) );
            
        } catch (FileNotFoundException ex) {
            this.tellErrorMessagerToShowMessage( ErrorMessager.FILE_ERROR );
        }
        return false;
    }
    
    // Asks a question to validate authenticity.
    private String askSecurityQuestion() {
        
        JFrame questionFrame = new JFrame();
        String questionAnswer = 
                JOptionPane.showInputDialog(
                    questionFrame,
                    this.SECURITY_QUESTION,
                    this.SECURITY_QUESTION_TITLE,
                    JOptionPane.QUESTION_MESSAGE
                );
        return questionAnswer;
    }
    
    // Validates the user's answer.
    private void verifyAnswer( String input_QuestionAnswer ) {
        
        boolean isAnswerCorrect = ( input_QuestionAnswer.equals( this.SECURITY_QUESTION_ANSWER ) );
        if ( isAnswerCorrect ) {
            this.callPasswordManager();
            
        } else {
            this.tellErrorMessagerToShowMessage( ErrorMessager.SECURITY_QUESTION_ERROR );
        }
    }
    
    // Goes to the Password controller.
    private void callPasswordManager(){
        
        this.closeAccessDoor();
        new PasswordManager();
    }
    
    // Shows an error message to the user.
    private void tellErrorMessagerToShowMessage(String input_ErrorMessage){
        
        ErrorMessager errorMessager = ErrorMessager.callErrorMessager();
        errorMessager.showErrorMessage( input_ErrorMessage );
    }

}
