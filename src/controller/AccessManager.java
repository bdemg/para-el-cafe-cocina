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
 * @author Antonio Soto
 */
public class AccessManager extends Controller {

    private final AccessDoor accessDoor;
    
    private final String SECURITY_QUESTION = "¿Cuál es su nombre?";
    private final String SECURITY_QUESTION_TITLE = "Pregunta de Seguridad";
    private final String SECURITY_QUESTION_ANSWER = "nombre";

    public AccessManager() {
        
        this.accessDoor = new AccessDoor();
        this.accessDoor.setResizable(false);
        this.accessDoor.setLocationRelativeTo(null);
        this.accessDoor.setVisible(true);
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
            this.accessDoor.dispose();
            OrdersManager ordersManager = new OrdersManager();
            
        } else {
            ErrorMessager errorMessager = ErrorMessager.callErrorMessager();
            errorMessager.showErrorMessage( errorMessager.INPUT_PASSWORD_ERROR );
            this.accessDoor.clearFields();
        }
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
            PasswordManager passwordManager = new PasswordManager();
            
        } else {
            ErrorMessager errorMessager = ErrorMessager.callErrorMessager();
            errorMessager.showErrorMessage(errorMessager.SECURITY_QUESTION_ERROR);
        }
    }

}
