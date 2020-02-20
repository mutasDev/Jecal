import de.adesso.jecal.crypto.cipher.aes.AESCipher;
import de.adesso.jecal.crypto.cipher.aes.AESEncryptOutput;

import java.util.Arrays;

public class Programm
{

    public static void main(String[] args){


        AESEncryptOutput out = AESCipher.AESEncrypt("hello");
        System.out.println("1)"+Arrays.toString("hello".getBytes()) );

        System.out.println("2)"+ Arrays.toString(out.getCiphertext()));

        System.out.println("3)"+Arrays.toString(AESCipher.AESDecrypt(out.getCiphertext(), out.getKey(), out.getIv())));
    }

}
