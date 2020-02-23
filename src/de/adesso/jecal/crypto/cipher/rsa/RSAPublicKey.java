package de.adesso.jecal.crypto.cipher.rsa;

import java.security.PublicKey;

public class RSAPublicKey {
    PublicKey key;


    public RSAPublicKey(PublicKey key) {
        this.key = key;
    }

    public PublicKey getKey() {
        return key;
    }

}