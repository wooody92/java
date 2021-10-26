package rsa;

import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
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

  public static PrivateKey keyStrToPrivateKey(String privateKeyStr) throws Exception {
    byte[] decodedPrivateKeyStr = Base64.getDecoder().decode(privateKeyStr);

    return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decodedPrivateKeyStr));
  }

  public static PublicKey keyStrToPublicKey(String publicKeyStr) throws Exception {
    byte[] decodedPublicKeyStr = Base64.getDecoder().decode(publicKeyStr.getBytes(StandardCharsets.UTF_8));

    return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decodedPublicKeyStr));
  }

  /* find public key using private key */
  public static PublicKey extractPublicKey(PrivateKey privateKey) throws Exception {
    RSAPrivateCrtKey rsaPrivateCrtKey = (RSAPrivateCrtKey) privateKey;
    RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(rsaPrivateCrtKey.getModulus(), rsaPrivateCrtKey.getPublicExponent());

    return KeyFactory.getInstance("RSA").generatePublic(rsaPublicKeySpec);
  }
}
