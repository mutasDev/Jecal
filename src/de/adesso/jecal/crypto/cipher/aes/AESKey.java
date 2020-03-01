package de.adesso.jecal.crypto.cipher.aes;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class AESKey {

    private byte[] key;


    public AESKey(SecretKeySpec key){
        this.key = key.getEncoded();
    }

    public Key getKey() {
        return new SecretKeySpec(key, "AES");
    }
}
