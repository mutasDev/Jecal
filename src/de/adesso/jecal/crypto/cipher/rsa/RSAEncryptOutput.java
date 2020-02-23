package de.adesso.jecal.crypto.cipher.rsa;

import java.security.PublicKey;

public class RSAEncryptOutput {
    private byte[] ciphertext;
    private PublicKey key;

    public RSAEncryptOutput(byte[] ciphertext,  PublicKey key){
        this.ciphertext = ciphertext;
        this.key = key;
    }

    public byte[] getCiphertext(){
        return ciphertext;
    }


    public PublicKey getKey() {
        return key;
    }
}

