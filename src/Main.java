import _59frames.Ds._59utils.validation.PasswordStrength;

import static _59frames.Ds._59utils.validation.Validator.*;

public class Main {
    public static void main(String[] args) {
        String password = "Seife!1012";
        String email = "info@danielseifert.ch";

        System.out.println(isEmail(email));
        System.out.println(isPassword(password, PasswordStrength.VERY_LOW));
    }
}
