package _59frames.Ds._59utils.crypt;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;

class KryptoniteEncryptor {
    private Cipher cipher;

    KryptoniteEncryptor(PublicKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        this.cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        this.cipher.init(Cipher.ENCRYPT_MODE, key);
    }

    String encrypt(String clear) {
        try {
            byte[] encryptedbytes = cipher.doFinal(clear.getBytes(StandardCharsets.UTF_8));
            return new String(Base64.getEncoder().encode(encryptedbytes));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
