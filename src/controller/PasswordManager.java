package controller;

import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

import daos.PasswordFileDAO;
import model.ErrorMessager;
import model.PasswordCypher;
import model.Keywords;
import view.KeyResetBoard;

/**
 * This class manages the possible new user password information.
 * @author (c) Copyright 2016 José A. Soto. All Rights Reserved.
 */
public class PasswordManager extends Controller {
    
    private static final PasswordManager passwordManager = new PasswordManager();
    
    private final KeyResetBoard keyResetBoard;
    
    public static PasswordManager callPasswordManager(){
        
        return PasswordManager.passwordManager;
    }

    private PasswordManager() {
        
        this.keyResetBoard = new KeyResetBoard();
        
        this.addActionListeners();
    }
    
    @Override
    protected void addActionListeners() {
        
        this.keyResetBoard.getButtonOk().addActionListener(this);
    }

    @Override
    public void actionPerformed( ActionEvent event ) {
        
        Object eventSource = event.getSource();
        if ( isPasswordValid( eventSource ) ) {
            this.validateNewPassword();
        }
    }
    
    private boolean isPasswordValid ( Object eventSource ) {
        
        return eventSource == this.keyResetBoard.getButtonOk() ;
    }
    
    // Confirms if the new password is correct. Delegates next events if true.
    private void validateNewPassword() {
        
        if ( arePasswordsMatching() ) {
            this.tellDAOToStoreNewPassword();
            this.callAccessManager();
            
        } else {
            this.tellErrorMessagerToShowMessage(ErrorMessager.INPUT_PASSWORD_ERROR );
            this.cleanKeyResetBoardFields();
        }
    }
    
    // Checks if the new password is correct.
    private boolean arePasswordsMatching() {
        
        String newPassword = this.keyResetBoard.getNewPasswordField().getText();
        String confirmedNewPassword = 
                this.keyResetBoard.getConfirmNewPasswordField().getText();
        
        boolean isEntryBlank = 
                (( newPassword.equals( Keywords.EMPTY ) )
                && ( confirmedNewPassword.equals( Keywords.EMPTY ) ));
        
        boolean areEqualPasswords = ( newPassword.equals( confirmedNewPassword ));
        
        return ( !isEntryBlank && areEqualPasswords );
    }
    
    // Stores the new password into the password file.
    private void tellDAOToStoreNewPassword() {
        
        try {
            String newPassword = this.keyResetBoard.getNewPasswordField().getText();
            PasswordCypher passwordCypher = PasswordCypher.callPasswordCypher();
            
            String encryptedPassword = passwordCypher.encryptPassword( newPassword );
            PasswordFileDAO passwordFileDAO = PasswordFileDAO.getPasswordFileDAO();
            passwordFileDAO.storePassword( encryptedPassword );
            
        } catch (FileNotFoundException ex) {
            this.tellErrorMessagerToShowMessage( ErrorMessager.FILE_ERROR );
        }
    }
    
    // Goes to the AccessDoor controller.
    private void callAccessManager() {
        
        this.closeKeyResetBoard();
        AccessManager.callAccessManager();
    }
    
    // Closes the window.
    private void closeKeyResetBoard(){
        
        this.keyResetBoard.dispose();
    }
    
    // Resets the window.
    private void cleanKeyResetBoardFields(){
        
        this.keyResetBoard.clearFields();
    }
    
    // Shows an error message to the user.
    private void tellErrorMessagerToShowMessage(String input_ErrorMessage){
        
        ErrorMessager errorMessager = ErrorMessager.callErrorMessager();
        errorMessager.showErrorMessage( input_ErrorMessage );
    }
}
