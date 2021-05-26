package aes256;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.Charset;
import java.util.Base64;


public class AES256Util {

  public static String encrypt(String secretKey, String plainData) throws Exception {
    String IV = secretKey.substring(0, 16); // 16byte

    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
    IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes(Charset.forName("UTF-8")));

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

    byte[] encryptedData = cipher.doFinal(plainData.getBytes("UTF-8"));

    // Base64로 인코딩하지 않으면 깨짐
    return Base64.getEncoder().encodeToString(encryptedData);
  }

  public static String decrypt(String secretKey, String encodedData) throws Exception {
    String IV = secretKey.substring(0, 16); // 16byte

    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
    IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes(Charset.forName("UTF-8")));

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

    byte[] decodedData = Base64.getDecoder().decode(encodedData);
    byte[] decryptedData = cipher.doFinal(decodedData);

    return new String(decryptedData, "UTF-8");
  }
}
