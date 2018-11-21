package _59frames.Ds._59utils.crypt;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.Base64;

class KryptoniteDecryptor {
    private final Cipher cipher;

    KryptoniteDecryptor(PrivateKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        this.cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        this.cipher.init(Cipher.DECRYPT_MODE, key);
    }

    String decrypt(String encrypted) {
        try {
            byte[] encryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encrypted.getBytes()));
            return new String(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
