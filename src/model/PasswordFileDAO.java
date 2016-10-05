package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Antonio Soto
 */
public class PasswordFileDAO {

    private static final PasswordFileDAO instance = new PasswordFileDAO();

    private final String PASSWORD_FILE = "pecc.lo";

    private PasswordFileDAO() {
    }

    public static PasswordFileDAO getInstance() {
        return instance;
    }

    public String readPassword() {
        try {
            FileReader ReadFile = new FileReader(PASSWORD_FILE);
            Scanner FileScanner = new Scanner(ReadFile);
            String password = FileScanner.nextLine();
            return password;
        } catch (FileNotFoundException ex) {
            ErrorMessager errorMessager = ErrorMessager.getInstance();
            errorMessager.showErrorMessage(errorMessager.FILE_ERROR);
        }
        return null;
    }

    public void writePassword(String password) {
        try {
            PrintWriter writeFile = new PrintWriter(PASSWORD_FILE);
            writeFile.println(password);
            writeFile.close();
        } catch (FileNotFoundException ex) {
            ErrorMessager errorMessager = ErrorMessager.getInstance();
            errorMessager.showErrorMessage(errorMessager.FILE_ERROR);
        }
    }

}
