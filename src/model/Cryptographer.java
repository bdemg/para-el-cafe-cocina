package model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author Antonio Soto
 */
public class Cryptographer {

    public String encryptMessage(String inputMessage) {
        Base64.Encoder encoder = Base64.getEncoder();
        String outputMessage = encoder.encodeToString(inputMessage.getBytes(StandardCharsets.UTF_8));
        return outputMessage;
    }

    public String decryptMessage(String inputMessage) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedMessage = decoder.decode(inputMessage);
        String outputMessage = new String(decodedMessage);
        return outputMessage;
    }

}
