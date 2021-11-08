package sha256;

import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import rsa.RSAUtil;

public class Main {

    public static void main(String[] args) throws Exception {

        // generate keypair
        KeyPair keyPair = RSAUtil.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // init
        String plainText = "hello world";

        // sign
        String signature = SHA256Util.sign(plainText, privateKey);
        System.out.println("signature : " + signature);

        // verify
        boolean verifiedResult = SHA256Util.verify(plainText, publicKey, signature);
        System.out.println("signature equality : " + verifiedResult);

        // key handling
        String privateKeyStr = keyToKeyStr(privateKey);
        String publicKeyStr = keyToKeyStr(publicKey);

        PrivateKey privateKey2 = RSAUtil.keyStrToPrivateKey(privateKeyStr);
        PublicKey publicKey2 = RSAUtil.keyStrToPublicKey(publicKeyStr);

        PublicKey extractedPublicKey = RSAUtil.extractPublicKey(privateKey);
        System.out.println("public-key equality : " + publicKey.equals(extractedPublicKey));
    }

    private static String keyToKeyStr(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
}
