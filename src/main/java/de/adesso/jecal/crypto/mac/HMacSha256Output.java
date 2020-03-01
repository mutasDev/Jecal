package de.adesso.jecal.crypto.mac;

public class HMacSha256Output {


    public HMacSha256Output(byte[] message){
        this.message = message;
    }

    private byte[] message;

    public byte[] getMessage() {
        return message;
    }
}
