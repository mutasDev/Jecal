package de.adesso.jecal.crypto.cipher.rsa;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSACipher {

    protected RSACipher(){
    }

    public static RSAEncryptOutput RSAEncrypt(String plaintext, PublicKey publicKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return RSAEncrypt(plaintext.getBytes(StandardCharsets.UTF_8), publicKey);
    }

    public static RSAEncryptOutput RSAEncrypt(byte[] plaintext, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSha-256AndMGF1Padding");

        cipher.init(Cipher.ENCRYPT_MODE,publicKey );
        RSAEncryptOutput ret = new RSAEncryptOutput(cipher.doFinal(plaintext), publicKey);
        return ret;
    }

    public static byte[] RSADecrypt(String ciphertext, PrivateKey key ) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        return RSADecrypt(ciphertext.getBytes(StandardCharsets.UTF_8), key);
    }

    public static byte[] RSADecrypt(byte[] ciphertext, PrivateKey key) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSha-256AndMGF1Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);

        return cipher.doFinal(ciphertext);
    }



}
