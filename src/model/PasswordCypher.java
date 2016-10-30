package model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author Antonio Soto
 */
public class PasswordCypher {
    
    private static final PasswordCypher passwordCypher = new PasswordCypher();
    
    private PasswordCypher(){
        ;
    }
    
    public static PasswordCypher callPasswordCypher(){
        
        return passwordCypher;
    }
    
    public String encryptPassword( String input_Password ) {
        
        Base64.Encoder PasswordEncoder = Base64.getEncoder();
        String outputEncryptedPassword = PasswordEncoder.encodeToString( 
            input_Password.getBytes( StandardCharsets.UTF_8 ) 
        );
        return outputEncryptedPassword;
    }

    public String decryptPassword( String input_EncryptedPassword ) {
        
        Base64.Decoder PasswordDecoder = Base64.getDecoder();
        byte[] decodedPassword = PasswordDecoder.decode( input_EncryptedPassword );
        String outputPassword = new String( decodedPassword );
        return outputPassword;
    }

}
