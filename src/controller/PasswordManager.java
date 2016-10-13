package controller;

import java.awt.event.ActionEvent;

import model.ErrorMessager;
import model.PasswordCypher;
import daos.PasswordFileDAO;
import view.KeyReset;

public class PasswordManager extends Controller {

    private final KeyReset keyreset;

    private final String EMPTY = "";

    public PasswordManager() {
        
        this.keyreset = new KeyReset();
        this.keyreset.setResizable(false);
        this.keyreset.setLocationRelativeTo(null);
        this.keyreset.setVisible(true);
        this.addActionListeners();
    }

    @Override
    public void actionPerformed( ActionEvent event ) {
        Object eventSource = event.getSource();
        if ( isPasswordValid( eventSource ) ) {
            this.validateNewPassword();
        }
    }
    
    private boolean isPasswordValid ( Object eventSource ) {
        
        return eventSource == this.keyreset.getButtonOk() ;
    }

    @Override
    protected void addActionListeners() {
        
        this.keyreset.getButtonOk().addActionListener(this);
    }

    private void validateNewPassword() {
        
        if ( arePasswordsMatching() ) {
            this.storeNewPassword();
            this.callAccessManager();
            
        } else {
            ErrorMessager errorMessager = ErrorMessager.callErrorMessager();
            errorMessager.showErrorMessage( errorMessager.INPUT_PASSWORD_ERROR );
            this.keyreset.clearFields();
        }
    }

    private void storeNewPassword() {
        
        String newPassword = this.keyreset.getNewPasswordField().getText();
        PasswordCypher passwordCypher = PasswordCypher.callPasswordCypher();
        String encryptedPassword = passwordCypher.encryptPassword( newPassword );
        PasswordFileDAO passwordFileDAO = PasswordFileDAO.getPasswordFileDAO();
        passwordFileDAO.storePassword( encryptedPassword );
    }

    private boolean arePasswordsMatching() {
        
        String newPassword = this.keyreset.getNewPasswordField().getText();
        String confirmedNewPassword
                = this.keyreset.getConfirmNewPasswordField().getText();
        boolean isEntryBlank = (( newPassword.equals( this.EMPTY ) )
                && ( confirmedNewPassword.equals( this.EMPTY ) ));
        boolean areEqualPasswords = ( newPassword.equals( confirmedNewPassword ));
        return ( !isEntryBlank && areEqualPasswords );
    }

    private void callAccessManager() {
        
        this.keyreset.dispose();
        AccessManager accessManager = new AccessManager();
    }
}
