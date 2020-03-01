package de.adesso.jecal.crypto.digest;

public interface IShaDigest {

    byte[] digest(byte[] input);
    byte[] digest(String input);
}
