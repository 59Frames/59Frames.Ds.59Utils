package _59frames.Ds._59utils.crypto;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class SymmetricKeyCryptor {
    private static final String ALGORITHM = "AES";
    private final byte[] keyValue;
    private final Cipher cipher;

    public SymmetricKeyCryptor(@NotNull SecretKeySpec secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.keyValue = secretKey.getEncoded();
        this.cipher = Cipher.getInstance(ALGORITHM);
    }

    public String encrypt(String plain) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Key key = generateKey();
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = cipher.doFinal(plain.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    public String decrypt(String encrypted) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Key key = generateKey();
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decValue = Base64.getDecoder().decode(encrypted);
        byte[] decodedValue = cipher.doFinal(decValue);
        return new String(decodedValue);
    }

    @NotNull
    @Contract(value = " -> new", pure = true)
    private Key generateKey() {
        return new SecretKeySpec(keyValue, ALGORITHM);
    }
}
