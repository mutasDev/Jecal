package de.adesso.jecal.crypto.cipher.aes;

public class InitVector {
    private byte[] iv;


    public InitVector(byte[] iv){
        this.iv = iv;
    }

    public byte[] getIv() {
        return iv;
    }
}
