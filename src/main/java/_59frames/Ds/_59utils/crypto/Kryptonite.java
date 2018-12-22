package _59frames.Ds._59utils.crypto;

import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class Kryptonite {
    private final PrivateKey privateKey;
    private final PublicKey publicKey;
    private final SecretKeySpec secretKey;

    public Kryptonite() throws NoSuchAlgorithmException {
        this(3072);
    }

    public Kryptonite(int keyLength) throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(keyLength);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();

        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[16];
        secureRandom.nextBytes(key);
        this.secretKey = new SecretKeySpec(key, "AES");
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public SecretKeySpec getSecretKey() {
        return secretKey;
    }
}
