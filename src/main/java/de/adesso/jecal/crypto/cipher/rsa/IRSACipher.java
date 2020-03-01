package de.adesso.jecal.crypto.cipher.rsa;


public interface IRSACipher {
    RSAEncryptOutput encrypt(String plaintext) throws RSAException;
    RSAEncryptOutput encrypt(byte[] plaintext) throws RSAException;

    byte[] decrypt(RSAEncryptOutput out) throws RSAException;

    RSAPrivateKey getPrivateKey();
    RSAPublicKey getPublicKey();
}
