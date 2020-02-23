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

    public int getRandomInt(){
        return sr.nextInt();
    }

    public float getRandomFloat(){
        return sr.nextFloat();
    }

    public boolean  getRandom(){
        return sr.nextBoolean();
    }

}
