package sha256;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
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
    }
}
