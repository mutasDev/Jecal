package de.adesso.jecal.crypto.cipher;


import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class TripleDESCipher {

    protected TripleDESCipher(byte[] key) {
    }

    public static byte[] TripleDESEncrypt (String plaintext, byte[] key){
        return TripleDESEncrypt(plaintext.getBytes(StandardCharsets.UTF_8), key);
    }

    public static byte[] TripleDESEncrypt(byte[] plaintext, byte[] key)  {
        try {
            // Generate IV
            byte[] iv = new byte[128/8];
            SecureRandom sr = SecureRandom.getInstanceStrong();
            sr.nextBytes(iv);
            IvParameterSpec initVector = new IvParameterSpec(iv);

            // Generate Key from parameter
            SecretKeySpec skey = new SecretKeySpec(key, "AES");

            // Init Cipher
            Cipher  cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey, initVector);
            return cipher.doFinal(plaintext);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
            System.out.println("Operation not finished");
        }
        return null;
    }





}
