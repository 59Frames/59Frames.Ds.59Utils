package _59frames.Ds._59utils.tool;

import java.util.List;

public class ArrayTools {
    public static int[] extractIntArray(List<String> array) {
        int[] arr = new int[array.size()];

        for (int i = 0; i < arr.length; i++) arr[i] = Integer.valueOf(array.get(i));

        return arr;
    }

    public static double[] extractDoubleArray(List<String> array) {
        double[] arr = new double[array.size()];

        for (int i = 0; i < arr.length; i++) arr[i] = Integer.valueOf(array.get(i));

        return arr;
    }
}
