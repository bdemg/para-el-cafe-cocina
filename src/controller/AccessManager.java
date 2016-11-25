package controller;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.ErrorMessager;
import model.PasswordCypher;
import daos.PasswordFileDAO;
import view.AccessDoor;

/**
 *
 * @author (c) Copyright 2016 José A. Soto. All Rights Reserved.
 */
public class AccessManager extends Controller {

    private final AccessDoor accessDoor;
    
    private final String SECURITY_QUESTION = "¿Cuál es su nombre?";
    private final String SECURITY_QUESTION_TITLE = "Pregunta de Seguridad";
    private final String SECURITY_QUESTION_ANSWER = "nombre";
    
    private final String EMPTY = "";

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
            this.enterAccessDoor();
            
        } else if ( isPasswordForgoten ( eventSource ) ) {
            String questionAnswer = this.askSecurityQuestion();
            this.callPasswordManager(questionAnswer);
        }
    }
    
    private boolean isAccessingDoor ( Object eventSource ) {
        
        return eventSource == this.accessDoor.getButtonEnterDoor();
    }
    
    private boolean isPasswordForgoten ( Object eventSource ) {
        
        return eventSource == this.accessDoor.getButtonForgotPassword();
    }

    private void enterAccessDoor() {
  
        if ( isAccessKey() ) {
            this.closeAccessDoor();
            OrdersManager.callOrdersManager();
            
        } else {
            this.tellErrorMessagerToShowMessage( ErrorMessager.INPUT_PASSWORD_ERROR );
            this.cleanAccessDoorFields();
        }
    }
    
    private void closeAccessDoor(){
        
        this.accessDoor.dispose();
    }
    
    private void cleanAccessDoorFields(){
        
        this.accessDoor.getPasswordField().setText( this.EMPTY );
    }

    private boolean isAccessKey() {
        
        PasswordFileDAO passwordFileDAO = PasswordFileDAO.getPasswordFileDAO();
        String encryptedPassword = passwordFileDAO.getStoredPassword();
        
        PasswordCypher passwordCypher = PasswordCypher.callPasswordCypher();
        String storedPassword = passwordCypher.decryptPassword( encryptedPassword );
        
        String enteredPassword = this.accessDoor.getPasswordField().getText();
        return ( storedPassword.equals( enteredPassword ) );
    }

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

    private void callPasswordManager( String input_QuestionAnswer ) {
        
        boolean isAnswerCorrect = ( input_QuestionAnswer.equals( this.SECURITY_QUESTION_ANSWER ) );
        if ( isAnswerCorrect ) {
            this.accessDoor.dispose();
            PasswordManager.callPasswordManager();
            
        } else {
            this.tellErrorMessagerToShowMessage( ErrorMessager.SECURITY_QUESTION_ERROR );
        }
    }
    
    private void tellErrorMessagerToShowMessage(String input_ErrorMessage){
        
        ErrorMessager errorMessager = ErrorMessager.callErrorMessager();
        errorMessager.showErrorMessage( input_ErrorMessage );
    }

}
