package daos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class can access and modify the password file.
 * @author (c) Copyright 2016 José A. Soto. All Rights Reserved.
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
    
    // Gets the stored password from the password file.
    public String getStoredPassword() throws FileNotFoundException {
            
        FileReader ReadFile = new FileReader( this.PASSWORD_FILE );
        Scanner FileScanner = new Scanner( ReadFile );
        String password = FileScanner.nextLine();
        return password;
    }
    
    // Stores the new password into the password file.
    public void storePassword( String input_Password ) throws FileNotFoundException {
        
        PrintWriter writeFile = new PrintWriter( this.PASSWORD_FILE );
        writeFile.println( input_Password );
        writeFile.close();
    }

}
