package de.adesso.jecal.crypto.mac;

import de.adesso.jecal.crypto.random.JecalRandom;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class HMacSha256 implements IHMacSha256 {

    private Mac mac;
    private MacSecret secret;

    public HMacSha256() throws HMacException {
        try {
            mac = Mac.getInstance("HmacSha256");
            JecalRandom ran = new JecalRandom();
            secret = new MacSecret(ran.getRandomBytes(20));
            SecretKeySpec key = new SecretKeySpec(secret.getSecret(), "HMacSha256");
            mac.init(key);
        } catch (Exception e) {
            throw new HMacException();
        }
    }

    public HMacSha256(MacSecret secret) throws HMacException {
        try {
            mac = Mac.getInstance("HMacSha256");
            secret = secret;
            SecretKeySpec key = new SecretKeySpec(secret.getSecret(), "HMacSha256");
            mac.init(key);
        } catch (Exception e) {
            throw new HMacException();
        }
    }


    public MacSecret getSecret() {
        return secret;
    }

    public HMacSha256Output generateMac(byte[] message){
        return new HMacSha256Output(mac.doFinal(message));
    }

    public HMacSha256Output generateMac(String message){
        return generateMac(message.getBytes(StandardCharsets.UTF_8));
    }
}
