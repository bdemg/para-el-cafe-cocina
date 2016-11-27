package model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * This class can cypher and decypher any password.
 * @author (c) Copyright 2016 José A. Soto. All Rights Reserved.
 */
public class PasswordCypher {
    
    private static final PasswordCypher passwordCypher = new PasswordCypher();
    
    private PasswordCypher(){
        ;
    }
    
    public static PasswordCypher callPasswordCypher(){
        
        return passwordCypher;
    }
    
    // Cyphers the user password.
    public String encryptPassword( String input_Password ) {
        
        Base64.Encoder PasswordEncoder = Base64.getEncoder();
        String outputEncryptedPassword = PasswordEncoder.encodeToString( 
            input_Password.getBytes( StandardCharsets.UTF_8 ) 
        );
        return outputEncryptedPassword;
    }
    
    // Decyphers the user password.
    public String decryptPassword( String input_EncryptedPassword ) {
        
        Base64.Decoder PasswordDecoder = Base64.getDecoder();
        byte[] decodedPassword = PasswordDecoder.decode( input_EncryptedPassword );
        String outputPassword = new String( decodedPassword );
        return outputPassword;
    }

}
