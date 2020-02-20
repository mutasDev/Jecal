package de.adesso.jecal.crypto.cipher.aes;

public class AESEncryptOutput {
    private byte[] ciphertext;
    private InitVector iv;
    private AESKey key;

    public AESEncryptOutput(byte[] ciphertext, InitVector iv, AESKey key){
        this.ciphertext = ciphertext;
        this.iv = iv;
        this.key = key;
    }

    public byte[] getCiphertext(){
        return ciphertext;
    }

    public InitVector getIv() {
        return iv;
    }

    public AESKey getKey() {
        return key;
    }
}
