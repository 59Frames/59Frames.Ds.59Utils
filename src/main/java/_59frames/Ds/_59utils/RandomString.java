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

    public RandomString(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.RANDOM = Objects.requireNonNull(random);
        this.SYMBOLS = symbols.toCharArray();
        this.BUFFER = new char[length];
    }

    /**
     * Create an alphanumeric string generator.
     */
    public RandomString(int length, Random random) {
        this(length, random, ALPHA_NUM);
    }

    /**
     * Create an alphanumeric strings from a secure generator.
     */
    public RandomString(int length) {
        this(length, Holder.random);
    }

    /**
     * Create session identifiers.
     */
    public RandomString() {
        this(21);
    }

    /**
     * Generate a random string.
     */
    @NotNull
    @Contract(" -> new")
    public String nextString() {
        for (int idx = 0; idx < BUFFER.length; ++idx)
            BUFFER[idx] = SYMBOLS[RANDOM.nextInt(SYMBOLS.length)];
        return new String(BUFFER);
    }

    /**
     * @param length => String length
     * @return random String
     */
    @NotNull
    public static String random(int length) {
        return new RandomString(length).nextString();
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

    private static class Holder {
        private static final SecureRandom random = new SecureRandom();
    }
}