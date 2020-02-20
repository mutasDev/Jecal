package de.adesso.jecal.crypto.cipher.aes;

public class AESKey {

    byte[] key;


    public AESKey(byte[] key){
        this.key = key;
    }

    public byte[] getKey() {
        return key;
    }
}
