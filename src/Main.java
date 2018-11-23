import _59frames.Ds._59utils.crypt.Kryptonite;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        try {
            Kryptonite kryptonite = new Kryptonite();

            String encrypted = kryptonite.encryptWithPublic("Daniel");

            System.out.println(encrypted);

            String decrypted = kryptonite.decryptWithPrivate(encrypted);

            System.out.println(decrypted);

            encrypted = kryptonite.encryptSymmetric("Daniel");

            System.out.println(encrypted);

            decrypted = kryptonite.decryptSymmetric(encrypted);

            System.out.println(decrypted);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}
