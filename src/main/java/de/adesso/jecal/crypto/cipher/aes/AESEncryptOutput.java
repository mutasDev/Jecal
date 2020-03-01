package de.adesso.jecal.crypto.cipher.aes;

public class AESEncryptOutput {
    private byte[] ciphertext;
    private InitVector iv;

    public AESEncryptOutput(byte[] ciphertext, InitVector iv){
        this.ciphertext = ciphertext;
        this.iv = iv;
    }

    public byte[] getCiphertext(){
        return ciphertext;
    }

    public InitVector getIv() {
        return iv;
    }

}
