package rsa;

import javax.crypto.Cipher;

import java.security.PrivateKey;
import java.security.PublicKey;

public class CipherUtil {

  public static byte[] encrypt(PublicKey publicKey, String inputData) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.ENCRYPT_MODE, publicKey);

    byte[] encryptedData = cipher.doFinal(inputData.getBytes());

    return encryptedData;
  }

  public static byte[] decrypt(PrivateKey privateKey, byte[] encryptedData) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.DECRYPT_MODE, privateKey);

    byte[] decryptedData = cipher.doFinal(encryptedData);

    return decryptedData;
  }
}
