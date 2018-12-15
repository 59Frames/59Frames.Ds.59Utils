package _59frames.Ds._59utils.validation;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public final class Validator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$");
    private static final Pattern IPV4_PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    private static final Pattern IPV6_STD_PATTERN = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    private static final Pattern POSITIVE_DIGIT_PATTERN = Pattern.compile("^\\d*\\.?\\d+$");
    private static final Pattern NEGATIVE_DIGIT_PATTERN = Pattern.compile("^-\\d*\\.?\\d+$");
    private static final Pattern DATE_MM_DD_YYYY_PATTERN = Pattern.compile("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$");
    private static final Pattern DATE_DD_MM_YYYY_PATTERN = Pattern.compile("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$");
    private static final Pattern HEX_COLOR_PATTERN = Pattern.compile("^#?([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$");
    private static final Pattern DOMAIN_PATTERN = Pattern.compile("^([a-z][a-z0-9-]+(\\.|-*\\.))+[a-z]{2,6}$");

    public static boolean isEmail(final String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isPassword(final String password, final int expectedLength, final RegexRule... rules) {
        Pattern pattern = RegexBuilder.buildRegex(expectedLength, rules);
        return pattern.matcher(password).matches();
    }

    public static boolean matchesRegexRules(@NotNull final String str, final RegexRule... rules) {
        Pattern pattern = RegexBuilder.buildRegex(rules);
        return pattern.matcher(str).matches();
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

    public static boolean isPositiveNumber(final String number) {
        return POSITIVE_DIGIT_PATTERN.matcher(number).matches();
    }

    public static boolean isNegativeNumber(final String number) {
        return NEGATIVE_DIGIT_PATTERN.matcher(number).matches();
    }

    public static boolean isNumber(final String number) {
        return isPositiveNumber(number) || isNegativeNumber(number);
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

    public static boolean isMMDDYYYYDate(final String date) {
        return DATE_MM_DD_YYYY_PATTERN.matcher(date).matches();
    }

    public static boolean isDDMMYYYYDate(final String date) {
        return DATE_DD_MM_YYYY_PATTERN.matcher(date).matches();
    }

    public static boolean isDate(final String date) {
        return isDDMMYYYYDate(date) || isMMDDYYYYDate(date);
    }

    public static boolean isHexColor(final String color) {
        return HEX_COLOR_PATTERN.matcher(color).matches();
    }

    public static boolean isDomain(final String domain) {
        return DOMAIN_PATTERN.matcher(domain).matches();
    }
}
