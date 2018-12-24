/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Libs;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class Encryption {
    
    private static final Random RANDOM = new SecureRandom();
    private static final String CHAR = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATION = 10000;
    private static final int KEY_LENGTH = 256;
    
    private static byte[] generateHash(char[] pass, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(pass, salt, ITERATION, KEY_LENGTH);
        Arrays.fill(pass, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing password : "+ e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }
    
    public static String generateSalt() {
        StringBuilder result = new StringBuilder(30);
        for(int i = 0; i < 30; i++) {
            result.append(CHAR.charAt(RANDOM.nextInt(CHAR.length())));
        }
        return new String(result);
    } 
    
    public static String encryptPass(String pass, String salt) {
        byte[] hash = generateHash(pass.toCharArray(), salt.getBytes());
        String result = Base64.getEncoder().encodeToString(hash);
        return result;
    }
    
    public static boolean isVerified(String input, String oripass, String salt) {
        String hash = encryptPass(input, salt);
        return (hash.equalsIgnoreCase(oripass));
    }
    
    
//    public static void main(String[] argv) {
//        String salt = generateSalt();
//        System.out.println("Pass : "+ encryptPass("hesti", salt));
//        System.out.println("Salt : "+ salt);
//    }
}
