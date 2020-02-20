package de.adesso.jecal.crypto.random;

import java.security.SecureRandom;

public class JecalRandom {
    private SecureRandom sr;
    public JecalRandom(){
        sr = new SecureRandom();
        sr.setSeed(sr.generateSeed(20));
    }

    public byte[] getRandomBytes(int length){
        byte [] ret = new byte[length];
        sr.nextBytes(ret);
        return ret;
    }
}
