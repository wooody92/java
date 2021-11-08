package sha256;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class SHA256Util {

    /* CLIENT */
    public static String sign(String plainText, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(plainText.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(signature.sign());
    }

    /* SERVER */
    public static boolean verify(String plainText, PublicKey publicKey, String clientSignature) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(plainText.getBytes(StandardCharsets.UTF_8));

        byte[] clientDecodedSignature = Base64.getDecoder().decode(clientSignature.getBytes());

        return signature.verify(clientDecodedSignature);
    }

    public static String signWithUrlEncoded(String plainText, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(plainText.getBytes(StandardCharsets.UTF_8));

        byte[] encodedSignature = Base64.getEncoder().encode(signature.sign());
        String encodedSignatureStr = new String(encodedSignature, StandardCharsets.UTF_8);
        return URLEncoder.encode(encodedSignatureStr, "UTF-8");
    }

    public static boolean verifyWithUrlDecoded(String plainText, PublicKey publicKey, String clientSignature) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(plainText.getBytes(StandardCharsets.UTF_8));

        String urlDecoded = URLDecoder.decode(clientSignature, "UTF-8");
        byte[] clientDecodedSignature = Base64.getDecoder().decode(urlDecoded.getBytes());
        return signature.verify(clientDecodedSignature);
    }
}
