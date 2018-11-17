package _59frames.Ds._59utils;

public enum PasswordRule {
    DIGITS("(?=.*[0-9])"),
    LOWERCASE("(?=.*[a-z])"),
    UPPERCASE("(?=.*[A-Z])"),
    SPECIAL_CHAR("(?=.*[@#$%^&+=!?.])"),
    NO_WHITESPACE("(?=\\S+$)"),
    LENGTH(".{8,}");

    public final String REGEX;

    PasswordRule(String regex) {
        this.REGEX = regex;
    }
}
