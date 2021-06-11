package rsa;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
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

    // init
    String inputData = "0000";

    // encrypt
    String encryptedData = RSAUtil.encrypt(publicKey, inputData);
    System.out.println("encryptedData : " + encryptedData);

    // decrypt
    String decryptedData = RSAUtil.decrypt(privateKey, encryptedData);
    System.out.println("decryptedData : " + decryptedData);
  }
}
