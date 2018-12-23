package _59frames.Ds._59utils.tool;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public final class ThreadTools {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void startAll(@NotNull Collection<? extends Thread> c) {
        for (Thread t : c) t.start();
    }

    public static void waitFor(@NotNull Collection<? extends Thread> c) throws InterruptedException {
        for(Thread t : c) t.join();
    }
}
