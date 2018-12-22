package _59frames.Ds._59utils.crypto;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

class KryptoniteCryptor {

    private final Cipher cipher;

    public KryptoniteCryptor() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    }

    public String encrypt(String clear, PublicKey key) throws InvalidKeyException {
        this.cipher.init(Cipher.ENCRYPT_MODE, key);
        try {
            byte[] encryptedBytes = cipher.doFinal(clear.getBytes(StandardCharsets.UTF_8));
            return new String(Base64.getEncoder().encode(encryptedBytes));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String decrypt(String encrypted, PrivateKey key) throws InvalidKeyException {
        this.cipher.init(Cipher.DECRYPT_MODE, key);
        try {
            byte[] encryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encrypted.getBytes()));
            return new String(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
