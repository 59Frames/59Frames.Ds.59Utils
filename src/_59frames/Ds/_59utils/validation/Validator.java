package _59frames.Ds._59utils.validation;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public final class Validator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", Pattern.CASE_INSENSITIVE);
    private static final Pattern IPV4_PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    private static final Pattern IPV6_STD_PATTERN = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static boolean isEmail(final String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isPassword(final String password, final int expectedLength, final PasswordRule... rules) {
        Pattern pattern = PasswordRegexBuilder.buildRegex(expectedLength, rules);
        return pattern.matcher(password).matches();
    }

    @Deprecated
    public static boolean isPassword(final String password) {
        return isPassword(password, PasswordStrength.NORMAL);
    }

    @Deprecated
    public static boolean isPassword(final String password, final PasswordStrength strength) {
        return matchesPasswordStrength(password, strength);
    }

    @Deprecated
    public static boolean matchesPasswordStrength(final String password, @NotNull final PasswordStrength strength) {
        return Pattern.compile(strength.REGEX, Pattern.CASE_INSENSITIVE).matcher(password).matches();
    }

    public static boolean isNumber(final String number, @NotNull final NumberType numberType) {
        return numberType.tryParse(number);
    }

    public static boolean isNumber(final Object number, final NumberType numberType) {
        return isNumber(String.valueOf(number), numberType);
    }

    public static boolean isNumber(final Object number) {
        return isNumber(String.valueOf(number), NumberType.DOUBLE);
    }

    public static boolean isIpv4(final String str) {
        return IPV4_PATTERN.matcher(str).matches();
    }

    public static boolean isIPv6StdAddress(final String input) {
        return IPV6_STD_PATTERN.matcher(input).matches();
    }

    public static boolean isIPv6HexCompressedAddress(final String input) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(input).matches();
    }

    public static boolean isIpv6(final String input) {
        return isIPv6StdAddress(input) || isIPv6HexCompressedAddress(input);
    }

}
