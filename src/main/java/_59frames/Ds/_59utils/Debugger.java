package _59frames.Ds._59utils;

import org.jetbrains.annotations.NotNull;

import java.io.PrintStream;

public class Debugger {
    public static void log(Object obj) {
        print(obj, System.out);
    }

    public static void warning(Object obj) {
        print(obj, System.err);
    }

    private static void print(Object obj, @NotNull PrintStream stream) {
        stream.println(obj);
    }
}
