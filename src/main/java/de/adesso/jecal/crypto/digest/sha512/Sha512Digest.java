package de.adesso.jecal.crypto.digest.sha512;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha512Digest {
    private Sha512Digest(){
    }

    public byte[] digest(byte[] input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        return digest.digest(input);
    }


    public byte[] digest(String input) throws NoSuchAlgorithmException {
        return digest(input.getBytes(StandardCharsets.UTF_8));
    }
}
