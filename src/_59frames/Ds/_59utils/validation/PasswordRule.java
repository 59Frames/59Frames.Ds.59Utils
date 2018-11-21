package _59frames.Ds._59utils.validation;

public enum PasswordRule {
    DIGITS("(?=.*[0-9])"),
    LOWERCASE("(?=.*[a-z])"),
    UPPERCASE("(?=.*[A-Z])"),
    SPECIAL_CHAR("(?=.*[@#$%^&+=!?.])"),
    NO_WHITESPACE("(?=\\S+$)"),
    LENGTH_8(".{8,}"),
    LENGTH_12(".{8,}"),
    LENGTH_16(".{16,}");

    public final String REGEX;

    PasswordRule(String regex) {
        this.REGEX = regex;
    }
}
