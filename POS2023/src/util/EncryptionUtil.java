/*
 */
package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class EncryptionUtil {

    public static String encryptText(String textToEncrypt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte byteArr[] = digest.digest(
                    textToEncrypt.getBytes(StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            for(byte byteText : byteArr){
                String hexValue = String.format("%o2x", byteText);
                 builder.append(hexValue);
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptionUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
