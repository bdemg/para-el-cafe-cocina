package controller;

import java.awt.event.ActionEvent;

import model.ErrorMessager;
import model.PasswordCypher;
import daos.PasswordFileDAO;
import view.KeyResetBoard;

/**
 * 
 * @author (c) Copyright 2016 José A. Soto. All Rights Reserved.
 */
public class PasswordManager extends Controller {
    
    private static final PasswordManager passwordManager = new PasswordManager();
    
    private final KeyResetBoard keyResetBoard;

    private final String EMPTY = "";
    
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

    private void validateNewPassword() {
        
        if ( arePasswordsMatching() ) {
            this.storeNewPassword();
            this.callAccessManager();
            
        } else {
            ErrorMessager errorMessager = ErrorMessager.callErrorMessager();
            errorMessager.showErrorMessage( errorMessager.INPUT_PASSWORD_ERROR );
            this.keyResetBoard.clearFields();
        }
    }

    private void storeNewPassword() {
        
        String newPassword = this.keyResetBoard.getNewPasswordField().getText();
        PasswordCypher passwordCypher = PasswordCypher.callPasswordCypher();
        
        String encryptedPassword = passwordCypher.encryptPassword( newPassword );
        PasswordFileDAO passwordFileDAO = PasswordFileDAO.getPasswordFileDAO();
        passwordFileDAO.storePassword( encryptedPassword );
    }

    private boolean arePasswordsMatching() {
        
        String newPassword = this.keyResetBoard.getNewPasswordField().getText();
        String confirmedNewPassword
                = this.keyResetBoard.getConfirmNewPasswordField().getText();
        boolean isEntryBlank = (( newPassword.equals( this.EMPTY ) )
                && ( confirmedNewPassword.equals( this.EMPTY ) ));
        boolean areEqualPasswords = ( newPassword.equals( confirmedNewPassword ));
        return ( !isEntryBlank && areEqualPasswords );
    }

    private void callAccessManager() {
        
        this.keyResetBoard.dispose();
        AccessManager accessManager = new AccessManager();
    }
}
