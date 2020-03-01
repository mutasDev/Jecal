package de.adesso.jecal.crypto.cipher.rsa;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class RSACipher implements IRSACipher{

    private RSAPrivateKey privKey;
    private RSAPublicKey pubKey;

    public RSACipher(RSAKeyPair rsaKeyPair){
        privKey = rsaKeyPair.getPrivateKey();
        pubKey = rsaKeyPair.getPublicKey();
    }

    public RSACipher(RSAPublicKey publicKey){
        this.pubKey = publicKey;
    }

    public RSACipher(RSAPrivateKey privKey){
        this.privKey = privKey;
    }

    public RSAEncryptOutput encrypt(String plaintext) throws RSAException {
        return encrypt(plaintext.getBytes(StandardCharsets.UTF_8));
    }

    public RSAEncryptOutput encrypt(byte[] plaintext) throws RSAException {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSha-256AndMGF1Padding");
            cipher.init(Cipher.ENCRYPT_MODE,pubKey.getKey());
            RSAEncryptOutput ret = new RSAEncryptOutput(cipher.doFinal(plaintext), pubKey);
            return ret;
        } catch (Exception e){
            throw new RSAException();
        }


    }



    public byte[] decrypt(RSAEncryptOutput out) throws RSAException {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSha-256AndMGF1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privKey.getKey());
            return cipher.doFinal(out.getCiphertext());
        } catch (Exception e){
            throw new RSAException();
        }
    }

    public RSAPublicKey getPublicKey(){
        return this.pubKey;
    }

    public RSAPrivateKey getPrivateKey(){
        return this.privKey;
    }
}



