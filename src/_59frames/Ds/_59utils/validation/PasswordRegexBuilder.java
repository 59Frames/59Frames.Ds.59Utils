package _59frames.Ds._59utils.validation;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

import static _59frames.Ds._59utils.tool.ArrayTools.removeRedundancies;

class PasswordRegexBuilder {

    @NotNull
    static Pattern buildRegex(int length, @NotNull PasswordRule... rules) {

        rules = removeRedundancies(rules);

        StringBuilder stringBuilder = new StringBuilder();
        String len = ".{"+length+",}";
        stringBuilder.append("^");

        for (PasswordRule definition : rules) {
            stringBuilder.append(definition.REGEX);
        }

        stringBuilder.append(len);
        stringBuilder.append("$");

        return Pattern.compile(stringBuilder.toString());
    }
}
