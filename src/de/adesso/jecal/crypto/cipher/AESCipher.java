package de.adesso.jecal.crypto.cipher;


import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class AESCipher {

    protected AESCipher(byte[] key) {
    }

    public static byte[] AESEncrypt (String plaintext, AESKey key){
        return AESEncrypt(plaintext.getBytes(StandardCharsets.UTF_8), key);
    }

    public static AESEncryptedText AESEncrypt(byte[] plaintext, AESKey key)  {
        try {
            // Generate IV
            byte[] iv = new byte[128/8];
            SecureRandom sr = SecureRandom.getInstanceStrong();
            sr.nextBytes(iv);
            IvParameterSpec initVector = new IvParameterSpec(iv);

            // Generate Key from parameter
           SecretKeySpec skey = new SecretKeySpec(key.key, "AES");

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

    public static byte[] AESDecrypt(byte[] ciphertext, byte[] key, byte[] iv){
        try {
            // Generate IV
            IvParameterSpec initVector = new IvParameterSpec(iv);

            // Generate Key from parameter
            SecretKeySpec skey = new SecretKeySpec(key, "AES");

            // Init Cipher
            Cipher  cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey, initVector);
            return cipher.doFinal(ciphertext);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
            System.out.println("Operation not finished");
        }
        return null;
    }
    }





