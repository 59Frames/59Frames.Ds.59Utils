package _59frames.Ds._59utils.crypt;

import javax.crypto.NoSuchPaddingException;
import java.security.*;

public class Kryptonite {
    private final PrivateKey privateKey;
    private final PublicKey publicKey;
    private final KryptoniteEncryptor encryptor;
    private final KryptoniteDecryptor decryptor;

    public Kryptonite() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        this(448);
    }

    public Kryptonite(int keyLength) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(keyLength);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
        this.encryptor = new KryptoniteEncryptor(publicKey);
        this.decryptor = new KryptoniteDecryptor(privateKey);
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public String encrypt(String clear) {
        return encryptor.encrypt(clear);
    }

    public String decrypt(String encrypted) {
        return decryptor.decrypt(encrypted);
    }
}
