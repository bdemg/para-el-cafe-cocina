package controller;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.ErrorMessager;
import model.PasswordCypher;
import model.PasswordFileDAO;
import view.AccessDoor;

/**
 *
 * @author Antonio Soto
 */
public class AccessManager extends Manager {

    private final AccessDoor accessDoor;

    public AccessManager() {
        this.accessDoor = new AccessDoor();
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
        if (isAccessKey()) {
            // Se accede al programa.
        } else {
            ErrorMessager errorMessager = ErrorMessager.getInstance();
            errorMessager.showErrorMessage(errorMessager.INPUT_PASSWORD_ERROR);
            this.accessDoor.clearFields();
        }
    }

    private boolean isAccessKey() {
        PasswordFileDAO passwordFileDAO = PasswordFileDAO.getInstance();
        String supposedPassword = passwordFileDAO.readPassword();
        PasswordCypher passwordCypher = PasswordCypher.getInstance();
        String password = passwordCypher.decryptPassword(supposedPassword);
        String key = this.accessDoor.getPasswordField().getText();
        return (password.compareTo(key) == 0);
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
            ErrorMessager errorMessager = ErrorMessager.getInstance();
            errorMessager.showErrorMessage(errorMessager.SECURITY_QUESTION_ERROR);
        }
    }

}
