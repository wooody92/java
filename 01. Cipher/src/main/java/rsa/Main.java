package rsa;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

public class Main {

  public static void main(String[] args) throws Exception {

    // generate keypair
    KeyPair keyPair = RSAUtil.generateKeyPair();
    PublicKey publicKey = keyPair.getPublic();
    PrivateKey privateKey = keyPair.getPrivate();

    // encoded key string
    String publicKeyStr = Base64.getEncoder().encodeToString(publicKey.getEncoded());
    String privateKeyStr = Base64.getEncoder().encodeToString(privateKey.getEncoded());
    System.out.println("public key : " + publicKeyStr);
    System.out.println("private key : " + privateKeyStr);

    // encrypt
    String encryptedData = RSAUtil.encrypt(publicKey, "Henry");
    System.out.println("encryptedData : " + encryptedData);

    // decrypt
    PrivateKey decodedPrivateKey = RSAUtil.getPrivateKey(privateKeyStr);
    String decryptedData = RSAUtil.decrypt(decodedPrivateKey, encryptedData);
    System.out.println("decryptedData : " + decryptedData);
  }

  private static void printKeySpec(PublicKey publicKey, PrivateKey privateKey) throws Exception {
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
    RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

    System.out.println("public key spec : " + publicKeySpec);
    System.out.println("private key spec : " + privateKeySpec);
  }
}
