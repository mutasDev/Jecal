import de.adesso.jecal.crypto.cipher.aes.*;
import de.adesso.jecal.crypto.cipher.rsa.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;


public class Programm
{
/*
    public void send(String plaintext) throws AESException {
        IAESCipher cipher = new AESCipher(); // new AESCipher();
        AESEncryptOutput aesEncryptOutput = cipher.encrypt(plaintext);
        AESKey skey = cipher.getKey();
        // send key over secure channel
        // send aesEncryptOutput to receiver
    }

    public void receive() throws AESException {
        //receive output from sender
        IAESCipher cipher = new AESCipher(); // new AESCipher();
        cipher.decrypt(aesEncryptOutput);
        byte[] test;
        String result = test.toString(StandardCharsets.UTF_8);
    }
*/
    public static void main(String[] args) throws AESException, RSAException {
      // AES Example

        IAESCipher aes = new AESCipher(); // new AESCipher();

        AESEncryptOutput aesEncryptOutput = aes.encrypt("hello".getBytes(StandardCharsets.UTF_8));
        AESKey skey = aes.getKey();

        // transfer aesEncryptOutput (safe)
        // transfer skey on a safe channel

        AESCipher aes2 = new AESCipher(skey);
        aes2.decrypt(aesEncryptOutput);

        AESEncryptOutput out = aes2.encrypt("hello".getBytes(StandardCharsets.UTF_8));


        System.out.println(Arrays.toString(aes2.decrypt(out)));

    // RSA Example

        RSAKeyPair keyPair = RSAKeyPair.genereateRSAKeyPair();
        IRSACipher rsa = new RSACipher(keyPair.getPublicKey());
        RSAEncryptOutput outrsa = rsa.encrypt("hello");

        IRSACipher rsa2 = new RSACipher(keyPair.getPrivateKey());
        System.out.println(Arrays.toString(rsa2.decrypt(outrsa)));




    }

}
