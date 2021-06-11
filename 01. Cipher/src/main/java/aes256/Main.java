package aes256;

import java.util.Base64;

public class Main {

  public static void main(String[] args) throws Exception {

    // init
    String secretKey = "pF5nMmGOeKtHuzwmUgkcHdqYQUmQGGTO"; // 32 byte
    String iv = "y7xBvUthwA7xLoBK"; // random 16 byte
    String planeData = "0000";

    // AES CBC
    String encryptedData = AES256Util.encrypt(secretKey, planeData, iv);
    System.out.println("AES-CBC encrypted data : " + encryptedData);

    String decryptedData = AES256Util.decrypt(secretKey, encryptedData, iv);
    System.out.println("AES-CBC decrypted data : " + decryptedData);

    // AES GCM
    String encryptedDataGCM = AES256Util.encryptByGCM(secretKey, planeData, iv);
    System.out.println("AES-GCM encrypted data : " + encryptedDataGCM);

    String decryptedDataGCM = AES256Util.decryptByGCM(secretKey, encryptedDataGCM, iv);
    System.out.println("AES-GCM decrypted data: " + decryptedDataGCM);

    System.out.println("encoded plane data : " + Base64.getEncoder().encodeToString(planeData.getBytes()));
  }
}
