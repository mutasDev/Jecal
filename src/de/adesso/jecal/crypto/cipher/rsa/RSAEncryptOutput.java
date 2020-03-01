package de.adesso.jecal.crypto.cipher.rsa;

import java.security.PublicKey;

public class RSAEncryptOutput {
    private byte[] ciphertext;
    private RSAPublicKey key;

    public RSAEncryptOutput(byte[] ciphertext,  RSAPublicKey key){
        this.ciphertext = ciphertext;
        this.key = key;
    }

    public byte[] getCiphertext(){
        return ciphertext;
    }


    public RSAPublicKey getKey() {
        return key;
    }
}

