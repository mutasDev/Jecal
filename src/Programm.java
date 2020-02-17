import de.adesso.jecal.crypto.cipher.AESCipher;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class Programm
{

    public static void main(String[] args){


        System.out.println(AESCipher.AESEncrypt("Hello", "TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest".getBytes(StandardCharsets.UTF_8)));
    }

}
