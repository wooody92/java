package aes256;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.Charset;
import java.util.Base64;


public class AES256Util {

  public static final int GCM_TAG_LENGTH = 128; // 16 * 8

  public static String encrypt(String secretKey, String plainData, String iv) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
    IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(Charset.forName("UTF-8")));

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

    byte[] encryptedData = cipher.doFinal(plainData.getBytes("UTF-8"));

    // Base64로 인코딩하지 않으면 깨짐
    return Base64.getEncoder().encodeToString(encryptedData);
  }

  public static String decrypt(String secretKey, String encodedData, String iv) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
    IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(Charset.forName("UTF-8")));

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

    byte[] decodedData = Base64.getDecoder().decode(encodedData);
    byte[] decryptedData = cipher.doFinal(decodedData);

    return new String(decryptedData, "UTF-8");
  }


  public static String encryptByGCM(String secretKey, String plainData, String iv) throws Exception {
    if (iv.length() != 16) {
      throw new IllegalArgumentException();
    }
    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
    GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv.getBytes());

    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec);

    byte[] encryptedData = cipher.doFinal(plainData.getBytes("UTF-8"));

    // Base64로 인코딩하지 않으면 깨짐
    return Base64.getEncoder().encodeToString(encryptedData);
  }

  public static String decryptByGCM(String secretKey, String encodedData, String iv) throws Exception {
    if (iv.length() != 16) {
      throw new IllegalArgumentException();
    }
    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
    GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv.getBytes());

    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, gcmParameterSpec);

    byte[] decodedData = Base64.getDecoder().decode(encodedData);
    byte[] decryptedData = cipher.doFinal(decodedData);

    return new String(decryptedData, "UTF-8");
  }
}
