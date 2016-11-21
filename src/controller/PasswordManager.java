package controller;

import java.awt.event.ActionEvent;

import model.ErrorMessager;
import model.PasswordCypher;
import daos.PasswordFileDAO;
import view.KeyResetBoard;

/**
 * 
 * @author Antonio Soto
 */
public class PasswordManager extends Controller {

    private final KeyResetBoard keyresetBoard;

    private final String EMPTY = "";

    public PasswordManager() {
        
        this.keyresetBoard = new KeyResetBoard();
        this.keyresetBoard.setResizable(false);
        this.keyresetBoard.setLocationRelativeTo(null);
        this.keyresetBoard.setVisible(true);
        this.addActionListeners();
    }
    
    @Override
    protected void addActionListeners() {
        
        this.keyresetBoard.getButtonOk().addActionListener(this);
    }

    @Override
    public void actionPerformed( ActionEvent event ) {
        Object eventSource = event.getSource();
        if ( isPasswordValid( eventSource ) ) {
            this.validateNewPassword();
        }
    }
    
    private boolean isPasswordValid ( Object eventSource ) {
        
        return eventSource == this.keyresetBoard.getButtonOk() ;
    }

    private void validateNewPassword() {
        
        if ( arePasswordsMatching() ) {
            this.storeNewPassword();
            this.callAccessManager();
            
        } else {
            ErrorMessager errorMessager = ErrorMessager.callErrorMessager();
            errorMessager.showErrorMessage( errorMessager.INPUT_PASSWORD_ERROR );
            this.keyresetBoard.clearFields();
        }
    }

    private void storeNewPassword() {
        
        String newPassword = this.keyresetBoard.getNewPasswordField().getText();
        PasswordCypher passwordCypher = PasswordCypher.callPasswordCypher();
        String encryptedPassword = passwordCypher.encryptPassword( newPassword );
        PasswordFileDAO passwordFileDAO = PasswordFileDAO.getPasswordFileDAO();
        passwordFileDAO.storePassword( encryptedPassword );
    }

    private boolean arePasswordsMatching() {
        
        String newPassword = this.keyresetBoard.getNewPasswordField().getText();
        String confirmedNewPassword
                = this.keyresetBoard.getConfirmNewPasswordField().getText();
        boolean isEntryBlank = (( newPassword.equals( this.EMPTY ) )
                && ( confirmedNewPassword.equals( this.EMPTY ) ));
        boolean areEqualPasswords = ( newPassword.equals( confirmedNewPassword ));
        return ( !isEntryBlank && areEqualPasswords );
    }

    private void callAccessManager() {
        
        this.keyresetBoard.dispose();
        AccessManager accessManager = new AccessManager();
    }
}
