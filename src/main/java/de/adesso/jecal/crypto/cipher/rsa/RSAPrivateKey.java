package de.adesso.jecal.crypto.cipher.rsa;


import java.security.PrivateKey;

public class RSAPrivateKey {
    PrivateKey key;


    public RSAPrivateKey(PrivateKey key) {
        this.key = key;
    }

    public PrivateKey getKey() {
        return key;
    }
}