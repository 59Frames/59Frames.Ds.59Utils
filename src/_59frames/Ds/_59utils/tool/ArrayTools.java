package _59frames.Ds._59utils.tool;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayTools {
    public static int[] extractIntArray(@NotNull final List<String> array) {
        int[] arr = new int[array.size()];

        for (int i = 0; i < arr.length; i++) arr[i] = Integer.valueOf(array.get(i));

        return arr;
    }

    public static double[] extractDoubleArray(@NotNull final List<String> array) {
        double[] arr = new double[array.size()];

        for (int i = 0; i < arr.length; i++) arr[i] = Integer.valueOf(array.get(i));

        return arr;
    }

    @NotNull
    public static <T> T[] removeRedundancies(@NotNull final T[] ts) {
        if (ts.length < 1)
            return ts;

        HashSet<T> set = new HashSet<>(Arrays.asList(ts));
        @SuppressWarnings("unchecked")
        final T[] a = (T[]) Array.newInstance(ts[0].getClass(), set.size());
        return set.toArray(a);
    }

    public static <T> void reverse(@NotNull T[] data) {
        T[] clone = data.clone();
        for ( int i = 0; i < clone.length; ++i ) {
            data[i] = clone[clone.length-1-i];
        }
    }
}
