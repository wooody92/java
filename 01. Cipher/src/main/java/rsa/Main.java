package rsa;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class Main {

  public static void main(String[] args) throws Exception {

    // generate keypair
    KeyPair keyPair = RSAUtil.generateKeyPair();
    PublicKey publicKey = keyPair.getPublic();
    PrivateKey privateKey = keyPair.getPrivate();

    System.out.println("public key : " + publicKey);
    System.out.println("private key : " + privateKey);

    // key spec
    printKeySpec(publicKey, privateKey);

    // encrypt
    byte[] encryptedData = RSAUtil.encrypt(publicKey, "Henry");
    System.out.println("encryptedData : " + new String(encryptedData));

    // decrypt
    byte[] decryptedData = RSAUtil.decrypt(privateKey, encryptedData);
    System.out.println("decryptedData : " + new String(decryptedData));
  }

  private static void printKeySpec(PublicKey publicKey, PrivateKey privateKey) throws Exception {
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
    RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

    System.out.println("public key spec : " + publicKeySpec);
    System.out.println("private key spec : " + privateKeySpec);
  }
}
