package de.adesso.jecal.crypto.mac;

import javax.crypto.Mac;
import java.security.NoSuchAlgorithmException;

public class HMacSha256 {

    protected HMacSha256(){}


    public static HMacSha256Output createMac(byte[] message){

    }
    public static boolean verify(byte[] message, byte[] macode) throws NoSuchAlgorithmException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.i



        return ret;
    }
}
