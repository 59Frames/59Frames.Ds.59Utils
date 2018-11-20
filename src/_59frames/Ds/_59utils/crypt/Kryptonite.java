package _59frames.Ds._59utils.crypt;

import java.security.*;

public class Kryptonite {
    private KeyPairGenerator keyGen;
    private KeyPair pair;
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private KryptoniteEncryptor encryptor;
    private KryptoniteDecryptor decryptor;

    public Kryptonite() throws NoSuchAlgorithmException {
        this(448);
    }

    public Kryptonite(int keyLength) throws NoSuchAlgorithmException {
        this.keyGen = KeyPairGenerator.getInstance("RSA");
        this.keyGen.initialize(keyLength);
        this.pair = this.keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
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
