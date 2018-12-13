import _59frames.Ds._59utils.validation.Validator;

import static _59frames.Ds._59utils.PromptHandler.print;
import static _59frames.Ds._59utils.validation.PasswordRule.*;
public class Test {
    public static void main(String[] args) {
        String password_true = "X12345!";

        print(Validator.isPassword(password_true, 8, DIGITS, SPECIAL_CHARS, LOWERCASE, DIGITS));
    }
}
