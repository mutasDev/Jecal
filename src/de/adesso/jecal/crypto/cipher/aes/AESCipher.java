package de.adesso.jecal.crypto.cipher.aes;


import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class AESCipher {

    protected AESCipher(AESKey key) {
    }

    public static AESEncryptOutput AESEncrypt (String plaintext){
        return AESEncrypt(plaintext.getBytes(StandardCharsets.UTF_8));
    }

    public static AESEncryptOutput AESEncrypt(byte[] plaintext)  {
        try {
            // Generate IV
            byte[] ivbytes = new byte[128/8];
            SecureRandom sr = SecureRandom.getInstanceStrong();
            sr.nextBytes(ivbytes);
            IvParameterSpec initVector = new IvParameterSpec(ivbytes);

            // Generate Key from parameter
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecretKey key = keyGenerator.generateKey();

            // Init Cipher
            Cipher  cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, initVector);


            //Save output data in wrapper object
            AESEncryptOutput out = new AESEncryptOutput(cipher.doFinal(plaintext), new InitVector(initVector.getIV()),new AESKey(key.getEncoded()));
            return out;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
            System.out.println("Operation not finished");
        }
        return null;
    }

    public static byte[] AESDecrypt(byte[] ciphertext, AESKey key, InitVector iv){
        return AESDecrypt(ciphertext,key.getKey(),iv.getIv());
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





