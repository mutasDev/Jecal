import de.adesso.jecal.crypto.cipher.aes.AESCipher;
import de.adesso.jecal.crypto.cipher.aes.AESEncryptOutput;
import de.adesso.jecal.crypto.cipher.rsa.RSACipher;
import de.adesso.jecal.crypto.cipher.rsa.RSAEncryptOutput;
import de.adesso.jecal.crypto.cipher.rsa.RSAKeyPair;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Programm
{

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {


        AESEncryptOutput out = AESCipher.AESEncrypt("hello");
        System.out.println("1)"+Arrays.toString("hello".getBytes()) );

        System.out.println("2)"+ Arrays.toString(out.getCiphertext()));

        System.out.println("3)"+Arrays.toString(AESCipher.AESDecrypt(out.getCiphertext(), out.getKey(), out.getIv())));



        //Generate RSA Key
        RSAKeyPair keyPair = RSAKeyPair.genereateRSAKeyPair();
        RSAEncryptOutput outt = RSACipher.RSAEncrypt("hello",  keyPair.getPublicKey());

        System.out.println("1)" + Arrays.toString("hello".getBytes()));

        System.out.println("2)"+ Arrays.toString(outt.getCiphertext()));

        System.out.println("3)"+ Arrays.toString(RSACipher.RSADecrypt(outt.getCiphertext(),keyPair.getPrivateKey())));
    }

}
