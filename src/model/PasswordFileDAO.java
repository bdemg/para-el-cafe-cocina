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

    private static final PasswordFileDAO passwordFileDAO = new PasswordFileDAO();

    private final String PASSWORD_FILE = "pecc.lo";

    private PasswordFileDAO() {
        ;
    }

    public static PasswordFileDAO getPasswordFileDAO() {
        
        return passwordFileDAO;
    }

    public String getStoredPassword() {
        
        try {
            
            FileReader ReadFile = new FileReader( this.PASSWORD_FILE );
            Scanner FileScanner = new Scanner( ReadFile );
            String password = FileScanner.nextLine();
            return password;
            
        } catch ( FileNotFoundException ex ) {
            ErrorMessager errorMessager = ErrorMessager.callErrorMessager();
            errorMessager.showErrorMessage( errorMessager.FILE_ERROR );
        }
        
        return null;
    }

    public void storePassword( String password ) {
        
        try {
            
            PrintWriter writeFile = new PrintWriter( PASSWORD_FILE );
            writeFile.println( password );
            writeFile.close();
            
        } catch ( FileNotFoundException ex ) {
            ErrorMessager errorMessager = ErrorMessager.callErrorMessager();
            errorMessager.showErrorMessage( errorMessager.FILE_ERROR );
        }
    }

}
