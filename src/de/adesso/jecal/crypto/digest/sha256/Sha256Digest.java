package de.adesso.jecal.crypto.digest.sha256;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Digest {

    private Sha256Digest(){
    }

    public static byte[] digest(byte[] input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(input);
    }


    public static byte[] digest(String input) throws NoSuchAlgorithmException {
        return digest(input.getBytes(StandardCharsets.UTF_8));
    }
}
