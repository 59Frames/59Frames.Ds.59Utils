package _59frames.Ds._59utils.validation;

import java.util.function.Function;

public enum NumberType {
    INTEGER((Function<String, Boolean>) s -> {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }),
    FLOAT((Function<String, Boolean>) s -> {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }),
    DOUBLE((Function<String, Boolean>) s -> {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }),
    LONG((Function<String, Boolean>) s -> {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    });

    private final Function<String, Boolean> parseFunction;

    NumberType(Function parseFunction) {
        this.parseFunction = parseFunction;
    }

    public boolean tryParse(String s) {
        return parseFunction.apply(s);
    }
}
