package _59frames.Ds._59utils.validation;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public final class Validator {
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    public static boolean isEmail(String email) {
        return Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE).matcher(email).matches();
    }

    public static boolean isPassword(String password) {
        return isPassword(password, PasswordStrength.NORMAL);
    }

    public static boolean isPassword(String password, PasswordStrength strength) {
        return matchesPasswordStrength(password, strength);
    }

    public static boolean matchesPasswordStrength(String password, @NotNull PasswordStrength strength) {
        return Pattern.compile(strength.REGEX, Pattern.CASE_INSENSITIVE).matcher(password).matches();
    }

    public static boolean isNumber(String number, @NotNull NumberType numberType) {
        return numberType.tryParse(number);
    }

    public static boolean isNumber(Object number, NumberType numberType) {
        return isNumber(String.valueOf(number), numberType);
    }

    public static boolean isNumber(Object number) {
        return isNumber(String.valueOf(number), NumberType.DOUBLE);
    }

}
