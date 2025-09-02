package practice;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class AESExample {

    public static void main(String[] args) throws Exception {
        // Generate AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // AES-256
        SecretKey secretKey = keyGen.generateKey();

        // Generate IV (16 bytes for AES)
        byte[] iv = new byte[16];
        java.security.SecureRandom random = new java.security.SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        String plaintext = "Shubha Ghimire";

        // Encrypt
        Cipher encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        byte[] encryptedBytes = encryptCipher.doFinal(plaintext.getBytes());
        String ciphertext = Base64.getEncoder().encodeToString(encryptedBytes);

        System.out.println("Encrypted: " + ciphertext);

        // Decrypt
        Cipher decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(ciphertext));
        String decryptedText = new String(decryptedBytes);

        System.out.println("Decrypted: " + decryptedText);
    }
}
