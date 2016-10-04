package controller;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Cryptographer;
import view.KeyReset;

public class PasswordManager extends Manager {

    private final KeyReset keyreset;
    private final Cryptographer cryptographer;

    public PasswordManager() {
        this.keyreset = new KeyReset();
        this.cryptographer = new Cryptographer();
        this.keyreset.setResizable(false);
        this.keyreset.setLocationRelativeTo(null);
        this.keyreset.setVisible(true);
        this.addActionListeners();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object eventSource = event.getSource();
        if (eventSource == this.keyreset.getButtonOk()) {
            this.storeNewPassword();
            this.callAccessManager();
        }
    }

    @Override
    protected void addActionListeners() {
        this.keyreset.getButtonOk().addActionListener(this);
    }

    private void storeNewPassword() {
        if (validateNewPassword()) {
            String newPassword = this.keyreset.getNewPasswordField().getText();
            String cryptedPassword = this.cryptographer.encryptMessage(newPassword);
            try {
                PrintWriter writeFile = new PrintWriter("pecc.lo");
                writeFile.println(cryptedPassword);
                writeFile.close();
            } catch (FileNotFoundException ex) {
                String errorMessage = "(Error) No se encontró el archivo. Consulte con el Ingeniero.";
                this.showErrorMessage(errorMessage);
            }
        } else {
            String errorMessage = "(Error) Contraseña inválida.";
            this.showErrorMessage(errorMessage);
        }
    }

    private boolean validateNewPassword() {
        String newPassword = this.keyreset.getNewPasswordField().getText();
        String confirmNewPassword = this.keyreset.getConfirmNewPasswordField().getText();
        boolean nullEntry = ((newPassword.compareTo("") == 0) && (confirmNewPassword.compareTo("") == 0));
        boolean equalPasswords = (newPassword.compareTo(confirmNewPassword) == 0);
        return (!nullEntry && equalPasswords);
    }

    private void showErrorMessage(String errorMessage) {
        JFrame errorFrame = new JFrame();
        String errorTitle = "¡Error!";
        JOptionPane.showMessageDialog(errorFrame, errorMessage, errorTitle, JOptionPane.ERROR_MESSAGE);
    }
    
    private void callAccessManager(){
        this.keyreset.dispose();
        AccessManager accessManager = new AccessManager();
    }
}
