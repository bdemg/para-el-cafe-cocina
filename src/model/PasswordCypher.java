package model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author Antonio Soto
 */
public class PasswordCypher {
    
    private static final PasswordCypher instance = new PasswordCypher();
    
    private PasswordCypher(){}
    
    public static PasswordCypher getInstance(){
        return instance;
    }

    public String encryptPassword(String inputPassword) {
        Base64.Encoder PasswordEncoder = Base64.getEncoder();
        String outputEncryptedPassword = 
                PasswordEncoder.encodeToString(inputPassword.getBytes(StandardCharsets.UTF_8));
        return outputEncryptedPassword;
    }

    public String decryptPassword(String inputEncryptedPassword) {
        Base64.Decoder PasswordDecoder = Base64.getDecoder();
        byte[] decodedPassword = PasswordDecoder.decode(inputEncryptedPassword);
        String outputPassword = new String(decodedPassword);
        return outputPassword;
    }

}
