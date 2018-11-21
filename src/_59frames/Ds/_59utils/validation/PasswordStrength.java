package _59frames.Ds._59utils.validation;

public enum PasswordStrength {
    // Minimum eight characters, at least one letter and one number
    VERY_LOW("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"),

    // Minimum eight characters, at least one letter, one number and one special character
    LOW("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$"),

    // Minimum eight characters, at least one uppercase letter, one lowercase letter and one number
    NORMAL("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$"),

    // Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character
    STRONG("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    public final String REGEX;

    PasswordStrength(String regex) {
        this.REGEX = regex;
    }
}
