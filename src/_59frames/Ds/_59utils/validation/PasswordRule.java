package _59frames.Ds._59utils.validation;

public enum PasswordRule {
    DIGITS("(?=.*[0-9])"),
    LOWERCASE("(?=.*[a-z])"),
    UPPERCASE("(?=.*[A-Z])"),
    SPECIAL_CHARS("(?=.*[@#$%!?^&+=])"),
    NO_WHITE_SPACE("(?=\\S+$)");

    public final String REGEX;

    PasswordRule(String regex) {
        this.REGEX = regex;
    }
}
