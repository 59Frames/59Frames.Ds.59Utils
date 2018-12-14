package _59frames.Ds._59utils.validation;

import java.util.regex.Pattern;

public enum RegexRule {
    DIGIT(Pattern.compile("(?=.*[0-9])")),
    LOWERCASE(Pattern.compile("(?=.*[a-z])")),
    UPPERCASE(Pattern.compile("(?=.*[A-Z])")),
    SPECIAL_CHAR(Pattern.compile("(?=.*[@#$%!?^&+=])")),
    NO_WHITE_SPACE(Pattern.compile("(?=\\S+$)"));

    public final Pattern PATTERN;

    RegexRule(Pattern pattern) {
        this.PATTERN = pattern;
    }
}
