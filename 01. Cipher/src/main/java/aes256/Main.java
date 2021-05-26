package aes256;

public class Main {

  public static void main(String[] args) throws Exception {

    String secretKey = "01234567890123456789012345678901"; // 32byte

    String encryptedData = AES256Util.encrypt(secretKey, "Henry");
    System.out.println("encryptedData : " + encryptedData);

    String decryptedData = AES256Util.decrypt(secretKey, encryptedData);
    System.out.println("decryptedData : " + decryptedData);
  }
}
