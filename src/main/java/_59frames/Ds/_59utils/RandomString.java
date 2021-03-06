package _59frames.Ds._59utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

/**
 * @author Daniel Seifert
 * @version 1.0
 * @since 1.0
 */
public final class RandomString {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = UPPER.toLowerCase(Locale.ROOT);
    private static final String DIGITS = "0123456789";
    private static final String ALPHA_NUM = UPPER + LOWER + DIGITS;
    private final Random RANDOM;
    private final char[] SYMBOLS;
    private final char[] BUFFER;

    /**
     * Constructs a new instance of type {@link RandomString}
     *
     * @param length    - the length of the desired string
     * @param random    - the random to pick chars
     * @param symbols   - the symbols to pick chars from
     */
    private RandomString(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.RANDOM = Objects.requireNonNull(random);
        this.SYMBOLS = symbols.toCharArray();
        this.BUFFER = new char[length];
    }

    /**
     * Generate a random string.
     */
    @Contract(" -> new")
    @NotNull
    public String nextString() {
        for (int idx = 0; idx < BUFFER.length; ++idx)
            BUFFER[idx] = SYMBOLS[RANDOM.nextInt(SYMBOLS.length)];
        return new String(BUFFER);
    }

    /**
     * @param length - String length
     * @return random String
     */
    @NotNull
    public static String randomString(int length) {
        return new RandomString.Builder().withLength(length).build().nextString();
    }

    /**
     * Creates an unique UID based on the {@link UUID} class and removes every -
     *
     * @return String
     * @see UUID
     */
    @NotNull
    public static String uid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * A simple holder class to hold a secured
     * static instance of random
     */
    private static class Holder {
        private static final SecureRandom random = new SecureRandom();
    }

    /**
     * Simple Builder class to construct random strings
     */
    public static class Builder {

        private String symbols;
        private Random random;
        private int length;

        public Builder() {
            symbols = ALPHA_NUM;
            random = Holder.random;
            length = 21;
        }

        public Builder withSymbols(String symbols) {
            if (symbols.length() < 2) throw new IllegalArgumentException();
            this.symbols = symbols;
            return this;
        }

        public Builder withLength(int length) {
            if (length < 1) throw new IllegalArgumentException();
            this.length = length;
            return this;
        }

        public Builder withRandom(Random random) {
            this.random = random;
            return this;
        }

        public RandomString build() {
            return new RandomString(length, random, symbols);
        }
    }
}