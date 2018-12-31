package _59frames.Ds._59utils.tool;

import _59frames.Ds._59utils.math.Silvester;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayTools {
    public static int[] extractIntArray(@NotNull final List<String> array) {
        int[] arr = new int[array.size()];

        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.valueOf(array.get(i));

        return arr;
    }

    public static double[] extractDoubleArray(@NotNull final List<String> array) {
        double[] arr = new double[array.size()];

        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.valueOf(array.get(i));

        return arr;
    }

    public static <T> T pickRandom(@NotNull final T[] data) {
        if (data.length > 0)
            return data[Silvester.randomInt(0, data.length - 1)];
        else throw new IllegalArgumentException("Array length was less than 1");
    }

    public static <T> T[] createArrayWithInitialValue(int length, @NotNull T init) {
        if (length < 0) throw new IllegalArgumentException();
        @SuppressWarnings("unchecked") final T[] arr = (T[]) Array.newInstance(init.getClass(), length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = init;
        }

        return arr;
    }

    @NotNull
    public static <T> T[] removeRedundanciesFrom(@NotNull final T[] data) {
        if (data.length < 2)
            return data;

        HashSet<T> set = new HashSet<>(Arrays.asList(data));
        @SuppressWarnings("unchecked") final T[] a = (T[]) Array.newInstance(data[0].getClass(), set.size());
        return set.toArray(a);
    }

    @Contract("_ -> param1")
    public static <T> T[] reverse(@NotNull final T[] data) {
        if (data.length < 2)
            return data;

        T[] clone = data.clone();
        for (int i = 0; i < clone.length; ++i) {
            data[i] = clone[clone.length - 1 - i];
        }

        return data;
    }
}
