package controller;

import java.awt.event.ActionEvent;

import model.ErrorMessager;
import model.PasswordCypher;
import model.PasswordFileDAO;
import view.KeyReset;

public class PasswordManager extends Manager {

    private final KeyReset keyreset;
    
    private final String EMPTY_INPUT = "";

    public PasswordManager() {
        this.keyreset = new KeyReset();
        this.keyreset.setResizable(false);
        this.keyreset.setLocationRelativeTo(null);
        this.keyreset.setVisible(true);
        this.addActionListeners();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object eventSource = event.getSource();
        if (eventSource == this.keyreset.getButtonOk()) {
            if (arePasswordsMatching()) {
                this.storeNewPassword();
                this.callAccessManager();
            } else {
                ErrorMessager errorMessager = ErrorMessager.getInstance();
                errorMessager.showErrorMessage(errorMessager.INPUT_PASSWORD_ERROR);
                this.keyreset.clearFields();
            }
        }
    }

    @Override
    protected void addActionListeners() {
        this.keyreset.getButtonOk().addActionListener(this);
    }

    private void storeNewPassword() {
        String newPassword = this.keyreset.getNewPasswordField().getText();
        PasswordCypher passwordCypher = PasswordCypher.getInstance();
        String cryptedPassword = passwordCypher.encryptPassword(newPassword);
        PasswordFileDAO passwordFileDAO = PasswordFileDAO.getInstance();
        passwordFileDAO.writePassword(cryptedPassword);
    }

    private boolean arePasswordsMatching() {
        String newPassword = this.keyreset.getNewPasswordField().getText();
        String confirmNewPassword = 
                this.keyreset.getConfirmNewPasswordField().getText();
        boolean isNullEntry = (
                (newPassword.equals(this.EMPTY_INPUT)) &&
                (confirmNewPassword.equals(this.EMPTY_INPUT))
                );
        boolean areEqualPasswords = (newPassword.equals(confirmNewPassword));
        return (!isNullEntry && areEqualPasswords);
    }

    private void callAccessManager() {
        this.keyreset.dispose();
        AccessManager accessManager = new AccessManager();
    }
}
