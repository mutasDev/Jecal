import de.adesso.jecal.crypto.cipher.aes.*;
import de.adesso.jecal.crypto.cipher.rsa.RSACipher;
import de.adesso.jecal.crypto.cipher.rsa.RSAEncryptOutput;
import de.adesso.jecal.crypto.cipher.rsa.RSAKeyPair;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Programm
{

    public void send() {
        IAESCipher cipher = new AESCipher(); // new AESCipher();
        AESEncryptOutput aesEncryptOutput = cipher.AESEncrypt(plaintext);
        AESKey skey = cipher.getKey();
        // send key over secure channel
        // send aesEncryptOutput to receiver
    }

    public void receive() {
        //receive output from sender
        IAESCipher cipher = new AESCipher(); // new AESCipher();
        aes2.decrypt(aesEncryptOutput);
        byte[] test;
        String result = test.toString(StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IAESCipher cipher = new AESCipher(); // new AESCipher();

        AESCipherWithKey aes = cipher.init();
        AESEncryptOutput aesEncryptOutput = aes.AESEncrypt("hello".getBytes(StandardCharsets.UTF_8));
        SecretKeySpec skey = aes.getSkey();

        // transfer aesEncryptOutput (safe)
        // transfer skey on a safe channel

        AESCipherWithKey aes2 = cipher.init(skey);
        aes2.decrypt(aesEncryptOutput);

        AESEncryptOutput out = cipher.AESEncrypt("hello".getBytes(StandardCharsets.UTF_8));

//        AESEncryptOutput out2 = cipher.AESEncrypt("hello".getBytes(StandardCharsets.UTF_8), out.getKey());
 //       System.out.println(Arrays.toString(out2.getCiphertext()));
        System.out.println(Arrays.toString(out.getCiphertext()));
 //       System.out.println("3)"+Arrays.toString(cipher.AESDecrypt(out.getCiphertext(), out.getKey(), out.getIv())));
//        System.out.println("4)" + Arrays.toString(cipher.AESDecrypt(out2.getCiphertext(), out2.getKey(), out2.getIv())));



        //Generate RSA Key
        RSAKeyPair keyPair = RSAKeyPair.genereateRSAKeyPair();
        RSAEncryptOutput outt = RSACipher.RSAEncrypt("hello",  keyPair.getPublicKey());

        System.out.println("1)" + Arrays.toString("hello".getBytes()));

        System.out.println("2)"+ Arrays.toString(outt.getCiphertext()));

        System.out.println("3)"+ Arrays.toString(RSACipher.RSADecrypt(outt.getCiphertext(),keyPair.getPrivateKey())));
    }

}
