package rsa;

import javax.crypto.Cipher;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class RSAUtil {

  public static KeyPair generateKeyPair() throws Exception {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(2048);

    return keyPairGenerator.genKeyPair();
  }

  public static String encrypt(PublicKey publicKey, String inputData) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.ENCRYPT_MODE, publicKey);

    byte[] encryptedData = cipher.doFinal(inputData.getBytes());

    return Base64.getEncoder().encodeToString(encryptedData);
  }

  public static String decrypt(PrivateKey privateKey, String encryptedData) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.DECRYPT_MODE, privateKey);

    byte[] decodedData = Base64.getDecoder().decode(encryptedData.getBytes());
    byte[] decryptedData = cipher.doFinal(decodedData);

    return new String(decryptedData);
  }

  public static PrivateKey getPrivateKey(String privateKeyStr) throws Exception {
    byte[] decodedPrivateKeyStr = Base64.getDecoder().decode(privateKeyStr);
    PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(decodedPrivateKeyStr);

    return KeyFactory.getInstance("RSA")
        .generatePrivate(pkcs8EncodedKeySpec);
  }
}
