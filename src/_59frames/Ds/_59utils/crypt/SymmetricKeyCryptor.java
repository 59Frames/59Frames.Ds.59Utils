package _59frames.Ds._59utils.crypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

class SymmetricKeyCryptor {
    private static final String ALGORITHM = "AES";
    private final byte[] keyValue;
    private final Cipher cipher;

    SymmetricKeyCryptor(SecretKeySpec secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.keyValue = secretKey.getEncoded();
        this.cipher = Cipher.getInstance(ALGORITHM);
    }

    String encrypt(String plain) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Key key = generateKey();
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = cipher.doFinal(plain.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    String decrypt(String encrypted) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Key key = generateKey();
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decValue = Base64.getDecoder().decode(encrypted);
        byte[] decodedValue = cipher.doFinal(decValue);
        return new String(decodedValue);
    }

    private Key generateKey() {
        return new SecretKeySpec(keyValue, ALGORITHM);
    }
}
