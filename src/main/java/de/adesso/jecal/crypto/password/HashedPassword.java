package de.adesso.jecal.crypto.password;

public class HashedPassword {
    private byte[] hash;
    private byte[] salt;

    public byte[] getHash() {
        return hash;
    }

    public HashedPassword(byte[] hash, byte[] salt){
        this.hash = hash;
        this.salt = salt;
    }

    public byte[] getSalt() {
        return salt;
    }
}
