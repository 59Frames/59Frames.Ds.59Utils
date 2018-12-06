package _59frames.Ds._59utils.validation;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public final class Validator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", Pattern.CASE_INSENSITIVE);
    private static final Pattern IPV4_PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    private static final Pattern IPV6_PATTERN = Pattern.compile("^([\\dA-F]{1,4}:|((?=.*(::))(?!.*\\3.+\\3))\\3?)([\\dA-F]{1,4}(\\3|:\\b)|\\2){5}(([\\dA-F]{1,4}(\\3|:\\b|$)|\\2){2}|(((2[0-4]|1\\d|[1-9])?\\d|25[0-5])\\.?\\b){4})\\z");


    public static boolean isEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
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

    public static boolean isIpv4(String str) {
        return IPV4_PATTERN.matcher(str).matches();
    }

    public static boolean isIpv6(String str) {
        return IPV6_PATTERN.matcher(str).matches();
    }

}
