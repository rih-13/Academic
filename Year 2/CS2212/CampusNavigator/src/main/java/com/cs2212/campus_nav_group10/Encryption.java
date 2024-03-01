package com.cs2212.campus_nav_group10;

/**
 * Class used to get encryption tools and encrypt and decrypt passwords.
 * Encryption is done via the {@link encrypt} method and decryption through {@link decryptPassword}.
 * @version: 1.2
 * @author: Ria Haque}
 */



import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.apache.commons.codec.binary.Base64;
import java.nio.file.Files;
import java.nio.file.Paths;




public class Encryption {
    
    
    /** Encryption key */
    private final String password = "encryptionkey"; //do not share or change
    /** Encoded version of encryped string */
    private String encodedString;
    
    
    /** Encryption constructor
     * Creates Encryption object with set key, allowing use of encrypt and decrypt with key */
    public Encryption() {
        
    }
    
   

    /** Encrypts given string and returns encrypted version
     * @param inputText text to be encrypted
     * @return encrypted String
     */
    public String encrypt(String inputText) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("1");
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setKeyObtentionIterations(20000);
        String encryptedCSV = encryptor.encrypt(inputText);
        
        
        byte[] encoded = Base64.encodeBase64(encryptedCSV.getBytes());
        String encodedString = new String(encoded);
        
       
        try {  
            return encodedString;
        }
        catch (Exception e) {
            return null;
        }

    }


    /**
     * Decrypts given and returns plain English version
     * @param inputText text to be decrypted
     * @return original String text
     */
    public String decryptPassword(String inputText) {
        System.out.println("Encoding this text: " + inputText);
        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword("1");
        decryptor.setAlgorithm("PBEWithMD5AndDES");
        decryptor.setKeyObtentionIterations(20000);

        byte[] decoded = Base64.decodeBase64(inputText.getBytes());
        String decryptedText = new String(decoded);

        return decryptor.decrypt(decryptedText);
    }
    
    
}
