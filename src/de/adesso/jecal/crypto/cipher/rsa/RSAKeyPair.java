package de.adesso.jecal.crypto.cipher.rsa;

import java.security.*;

public class RSAKeyPair {
    private KeyPair keyPair;

    private RSAKeyPair() {
    }

    public static RSAKeyPair genereateRSAKeyPair() {
        KeyPairGenerator generator = null;
        try {
            generator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("RSA Algorithm not found for KeyGeneration");
        }
        generator.initialize(2048, new SecureRandom());
        KeyPair pair = generator.generateKeyPair();

        RSAKeyPair rsaKeyPair = new RSAKeyPair();
        rsaKeyPair.keyPair = pair;

        return rsaKeyPair;
    }

    public RSAPrivateKey getPrivateKey() {
        return new RSAPrivateKey(keyPair.getPrivate());
    }

    public RSAPublicKey getPublicKey() {
        return new RSAPublicKey(keyPair.getPublic());
    }
}
