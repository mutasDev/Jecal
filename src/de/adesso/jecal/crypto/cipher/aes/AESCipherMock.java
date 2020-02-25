package de.adesso.jecal.crypto.cipher.aes;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class AESCipherMock implements IAESCipher {

    public AESCipherWithKey init() throws NoSuchAlgorithmException {
        return AESCipherWithKeyMock();
    }

    public AESCipherWithKey init(AESKey aesKey) throws NoSuchAlgorithmException {
        return AESCipherWithKeyMock();
    }

}
