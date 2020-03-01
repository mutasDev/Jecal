package de.adesso.jecal.crypto.cipher.aes;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESCipherWithKey {

    private SecretKeySpec skey;

    public AESCipherWithKey(SecretKeySpec skey) {
        this.skey = skey;
    }

    public SecretKeySpec getSkey() {
        return skey;
    }

    public AESEncryptOutput AESEncrypt(byte[] plaintext){

        try {
            // Generate IV
            byte[] ivbytes = new byte[128 / 8];
            SecureRandom sr = SecureRandom.getInstanceStrong();
            sr.nextBytes(ivbytes);
            IvParameterSpec initVector = new IvParameterSpec(ivbytes);

            // Init Cipher
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey , initVector);


            //Save output data in wrapper object
            AESEncryptOutput out = new AESEncryptOutput(cipher.doFinal(plaintext), new InitVector(initVector.getIV()), new AESKey(skey.getEncoded()));
            return out;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
            System.out.println("Operation not finished");
        }
        return null;
    }


}
