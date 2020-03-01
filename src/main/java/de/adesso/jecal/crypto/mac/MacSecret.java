package de.adesso.jecal.crypto.mac;

import java.nio.charset.StandardCharsets;

public class MacSecret {
    private byte[] secret;

    public MacSecret(byte[] secret) {
        this.secret = secret;
    }

    public MacSecret(String secret){
        this.secret = secret.getBytes(StandardCharsets.UTF_8);
    }

    public byte[] getSecret() {
        return secret;
    }

    public void setSecret(byte[] secret) {
        this.secret = secret;
    }
}
