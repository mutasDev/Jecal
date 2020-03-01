package de.adesso.jecal.crypto.password;

import de.adesso.jecal.crypto.random.JecalRandom;
import org.bouncycastle.crypto.generators.BCrypt;

public class PasswordHash {

    private JecalRandom ran;
    public PasswordHash(){
        ran = new JecalRandom();
    }

    public HashedPassword hashPassword(byte[] password){
        byte[] salt = ran.getRandomBytes(20);
        byte[] hash = BCrypt.generate(password, salt, 14);
        return new HashedPassword(hash, salt);
    }
}
