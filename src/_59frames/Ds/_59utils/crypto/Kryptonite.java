package _59frames.Ds._59utils.crypto;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class Kryptonite {
    private final PrivateKey privateKey;
    private final PublicKey publicKey;
    private final SecretKeySpec secretKey;
    private final KryptoniteCryptor kryptoniteCryptor;
    private final SymmetricKeyCryptor symmetricKeyCryptor;

    public Kryptonite() throws NoSuchAlgorithmException, NoSuchPaddingException {
        this(3072);
    }

    public Kryptonite(int keyLength) throws NoSuchAlgorithmException, NoSuchPaddingException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(keyLength);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();

        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[16];
        secureRandom.nextBytes(key);
        this.secretKey = new SecretKeySpec(key, "AES");

        this.kryptoniteCryptor = new KryptoniteCryptor();
        this.symmetricKeyCryptor = new SymmetricKeyCryptor(secretKey);
    }

    public String encryptWithPublic(String clear) throws InvalidKeyException {
        return kryptoniteCryptor.encrypt(clear, publicKey);
    }

    public String decryptWithPrivate(String encrypted) throws InvalidKeyException {
        return kryptoniteCryptor.decrypt(encrypted, privateKey);
    }

    public String encryptSymmetric(String clear) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        return symmetricKeyCryptor.encrypt(clear);
    }

    public String decryptSymmetric(String encrypted) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        return symmetricKeyCryptor.decrypt(encrypted);
    }

}
