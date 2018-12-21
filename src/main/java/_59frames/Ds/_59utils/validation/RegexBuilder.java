package _59frames.Ds._59utils.validation;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

import _59frames.Ds._59utils.tool.ArrayTools;

/**
* The RegexBuilder is responsible for building Regexes.
*
* @author Daniel Seifert
* @version 1.0
* @since 1.0
*/
class RegexBuilder {
    @NotNull
    static Pattern buildRegex(@NotNull RegexRule... rules) {

        rules = ArrayTools.removeRedundanciesFrom(rules);

        StringBuilder regexStringBuilder = new StringBuilder("^");

        for (RegexRule definition : rules) {
            regexStringBuilder.append(definition.PATTERN.toString());
        }

        regexStringBuilder.append("$");

        return Pattern.compile(regexStringBuilder.toString());
    }

    @NotNull
    static Pattern buildRegex(int length, @NotNull RegexRule... rules) {

        rules = ArrayTools.removeRedundanciesFrom(rules);

        StringBuilder regexStringBuilder = new StringBuilder("^");

        String len = ".{" + length + ",}";

        for (RegexRule definition : rules) {
            regexStringBuilder.append(definition.PATTERN.toString());
        }

        regexStringBuilder.append(len);
        regexStringBuilder.append("$");

        return Pattern.compile(regexStringBuilder.toString());
    }
}
