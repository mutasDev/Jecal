package de.adesso.jecal.crypto.cipher.aes;


import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class AESCipher implements IAESCipher {

    private AESKey aesKey;

    public AESCipher() throws AESException {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new AESException();
        }
        SecretKey key = keyGenerator.generateKey();
        SecretKeySpec skey = new SecretKeySpec(key.getEncoded(), "AES");
        this.aesKey = new AESKey(skey);
    }

    public AESCipher(AESKey aesKey) throws AESException {
        this.aesKey = aesKey;
    }

    public AESEncryptOutput encrypt(String plaintext) throws AESException {
        return encrypt(plaintext.getBytes(StandardCharsets.UTF_8));
    }

    public AESEncryptOutput encrypt(byte[] plaintext) throws AESException {
        try {
            // Generate IV
            byte[] ivbytes = new byte[128 / 8];
            SecureRandom sr = SecureRandom.getInstanceStrong();
            sr.nextBytes(ivbytes);
            IvParameterSpec initVector = new IvParameterSpec(ivbytes);
            // Init Cipher
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, this.aesKey.getKey() , initVector);
            //Save output data in wrapper object
             return new AESEncryptOutput(cipher.doFinal(plaintext), new InitVector(initVector.getIV()));
        } catch (Exception e) {
            throw new AESException();
        }
    }

    public byte[] decrypt(AESEncryptOutput input) throws AESException {
        try {
            // Generate IV
            IvParameterSpec initVector = new IvParameterSpec(input.getIv().getIv());
            // Init Cipher
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, this.aesKey.getKey(), initVector);
            return cipher.doFinal(input.getCiphertext());
        } catch (Exception e) {
            throw new AESException();
        }
    }

    public AESKey getAesKey() {
        return aesKey;
    }
}





