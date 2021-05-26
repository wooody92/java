package rsa;

import javax.crypto.Cipher;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAUtil {

  public static KeyPair generateKeyPair() throws Exception {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(2048);

    return keyPairGenerator.genKeyPair();
  }

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
