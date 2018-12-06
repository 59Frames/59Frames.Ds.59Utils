package _59frames.Ds._59utils;

import java.util.Scanner;

public class PromptHandler {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void warning(Object obj) {
        System.err.println(obj);
    }

    public static String read() {
        return SCANNER.nextLine();
    }

    public static String waitFor(String key) {
        System.out.print(key + ": ");
        return read();
    }
}
