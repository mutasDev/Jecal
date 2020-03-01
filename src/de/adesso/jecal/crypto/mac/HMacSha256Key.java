package de.adesso.jecal.crypto.mac;

import java.security.Key;

public class HMacSha256Key {
    private Key key;

    public HMacSha256Key(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }
}
