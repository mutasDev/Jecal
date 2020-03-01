package de.adesso.jecal.crypto.password;

public interface IPasswordHash {
    HashedPassword hashPassword(String password);
    HashedPassword hashPassword(byte[] password);
}
