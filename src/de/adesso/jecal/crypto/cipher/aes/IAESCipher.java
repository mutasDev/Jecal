package de.adesso.jecal.crypto.cipher.aes;


public interface IAESCipher {
    AESEncryptOutput encrypt(String plaintext) throws AESException;

    AESEncryptOutput encrypt(byte[] plaintext) throws AESException;

    byte[]decrypt(AESEncryptOutput input) throws AESException;
}
