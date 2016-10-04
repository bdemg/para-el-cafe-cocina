package controller;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Cryptographer;
import view.AccessDoor;

/**
 *
 * @author Antonio Soto
 */
public class AccessManager extends Manager {

    private final AccessDoor accessDoor;
    private final Cryptographer cryptographer;

    public AccessManager() {
        this.accessDoor = new AccessDoor();
        this.cryptographer = new Cryptographer();
        this.accessDoor.setResizable(false);
        this.accessDoor.setLocationRelativeTo(null);
        this.accessDoor.setVisible(true);
        this.addActionListeners();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object eventSource = event.getSource();
        if (eventSource == this.accessDoor.getButtonEnterDoor()) {
            this.enterAccessDoor();
        } else if (eventSource == this.accessDoor.getButtonForgotPassword()) {
            String questionAnswer = this.askSecurityQuestion();
            this.callPasswordManager(questionAnswer);
        }
    }

    @Override
    protected void addActionListeners() {
        this.accessDoor.getButtonEnterDoor().addActionListener(this);
        this.accessDoor.getButtonForgotPassword().addActionListener(this);
    }

    private void enterAccessDoor() {
        if (validateAccessKey()) {
            // Se accede al programa.
        } else {
            String errorMessage = "(Error) Contraseña inválida.";
            this.showErrorMessage(errorMessage);
        }
    }

    private boolean validateAccessKey() {
        try {
            FileReader file = new FileReader("pecc.lo");
            Scanner scanner = new Scanner(file);
            String message = scanner.nextLine();
            String password = this.cryptographer.decryptMessage(message);
            String key = this.accessDoor.getPasswordField().getText();
            if (password.compareTo(key) == 0) {
                return true;
            }
        } catch (FileNotFoundException ex) {
            String errorMessage = "(Error) No se encontró el archivo. Consulte con el Ingeniero.";
            this.showErrorMessage(errorMessage);
        }
        return false;
    }

    private void showErrorMessage(String errorMessage) {
        JFrame errorFrame = new JFrame();
        String errorTitle = "¡Error!";
        JOptionPane.showMessageDialog(errorFrame, errorMessage, errorTitle, JOptionPane.ERROR_MESSAGE);
    }

    private String askSecurityQuestion() {
        JFrame questionFrame = new JFrame();
        String questionMessage = "¿Cuál es su nombre?";
        String questionTitle = "Pregunta de Seguridad";
        String questionAnswer = JOptionPane.showInputDialog(questionFrame,
                questionMessage, questionTitle, JOptionPane.QUESTION_MESSAGE);
        return questionAnswer;
    }

    private void callPasswordManager(String questionAnswer) {
        boolean isAnswerCorrect = (questionAnswer.compareTo("nombre") == 0);
        if (isAnswerCorrect) {
            this.accessDoor.dispose();
            PasswordManager passwordManager = new PasswordManager();
        } else {
            String errorMessage = "(Error) No es la respuesta correcta.";
            this.showErrorMessage(errorMessage);
        }
    }

}
