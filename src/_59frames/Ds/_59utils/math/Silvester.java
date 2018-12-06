package _59frames.Ds._59utils.math;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class Silvester {

    private Silvester() {
    }

    public static final double E = 2.7182818284590452354D;
    public static final double PI = 3.1415926535897932384626433832795028841971693993751058209749445923078164D;
    public static final double TWO_PI = PI * 2;

    private static long negativeZeroFloatBits = Float.floatToRawIntBits(-0.0f);
    private static long negativeZeroDoubleBits = Double.doubleToRawLongBits(-0.0d);

    @Contract(pure = true)
    public static int round(float a) {
        int intBits = Float.floatToRawIntBits(a);
        int biasedExp = (intBits & FloatConstants.EXP_BIT_MASK)
                >> (FloatConstants.SIGNIFICAND_WIDTH - 1);
        int shift = (FloatConstants.SIGNIFICAND_WIDTH - 2
                + FloatConstants.EXP_BIAS) - biasedExp;
        if ((shift & -32) == 0) {
            int r = ((intBits & FloatConstants.SIGNIF_BIT_MASK)
                    | (FloatConstants.SIGNIF_BIT_MASK + 1));
            if (intBits < 0) {
                r = -r;
            }
            return ((r >> shift) + 1) >> 1;
        } else {
            return (int) a;
        }
    }

    @Contract(pure = true)
    public static long round(double a) {
        long longBits = Double.doubleToRawLongBits(a);
        long biasedExp = (longBits & DoubleConstants.EXP_BIT_MASK)
                >> (DoubleConstants.SIGNIFICAND_WIDTH - 1);
        long shift = (DoubleConstants.SIGNIFICAND_WIDTH - 2
                + DoubleConstants.EXP_BIAS) - biasedExp;
        if ((shift & -64) == 0) {
            long r = ((longBits & DoubleConstants.SIGNIF_BIT_MASK)
                    | (DoubleConstants.SIGNIF_BIT_MASK + 1));
            if (longBits < 0) {
                r = -r;
            }
            return ((r >> shift) + 1) >> 1;
        } else {
            return (long) a;
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static float round(float value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.floatValue();
    }

    @Contract(pure = true)
    public static long max(long a, long b) {
        return (a >= b) ? a : b;
    }

    @Contract(pure = true)
    public static int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    @Contract(pure = true)
    public static double max(double a, double b) {
        if (a != a)
            return a;
        if ((a == 0.0d) &&
                (b == 0.0d) &&
                (Double.doubleToRawLongBits(a) == negativeZeroDoubleBits)) {
            return b;
        }
        return (a >= b) ? a : b;
    }

    @Contract(pure = true)
    public static float max(float a, float b) {
        if (a != a)
            return a;
        if ((a == 0.0f) &&
                (b == 0.0f) &&
                (Float.floatToRawIntBits(a) == negativeZeroFloatBits)) {
            return b;
        }
        return (a >= b) ? a : b;
    }

    public static <T extends Comparable<T>> T max(@NotNull T a, T b) {
        if (a.compareTo(b) == 0)
            return a;

        return a.compareTo(b) > 0
                ? a
                : b;
    }

    @Contract(pure = true)
    public static long min(long a, long b) {
        return (a <= b) ? a : b;
    }

    @Contract(pure = true)
    public static int min(int a, int b) {
        return (a <= b) ? a : b;
    }

    @Contract(pure = true)
    public static double min(double a, double b) {
        return (a <= b) ? a : b;
    }

    @Contract(pure = true)
    public static float min(float a, float b) {
        return (a <= b) ? a : b;
    }

    public static <T extends Comparable<T>> T min(@NotNull T a, T b) {
        if (a.compareTo(b) == 0)
            return a;

        return a.compareTo(b) < 0
                ? a
                : b;
    }

    public static double copySign(double magnitude, double sign) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(sign) &
                (DoubleConstants.SIGN_BIT_MASK)) |
                (Double.doubleToRawLongBits(magnitude) &
                        (DoubleConstants.EXP_BIT_MASK |
                                DoubleConstants.SIGNIF_BIT_MASK)));
    }

    public static float copySign(float magnitude, float sign) {
        return Float.intBitsToFloat((Float.floatToRawIntBits(sign) &
                (FloatConstants.SIGN_BIT_MASK)) |
                (Float.floatToRawIntBits(magnitude) &
                        (FloatConstants.EXP_BIT_MASK |
                                FloatConstants.SIGNIF_BIT_MASK)));
    }

    public static double pow(double a, double b) {
        return StrictMath.pow(a, b);
    }

    @Contract(pure = true)
    public static double average(@NotNull int[] arr) {
        double sum = 0.0;

        for (int n : arr)
            sum += n;

        return (sum / arr.length);
    }

    @Contract(pure = true)
    public static double average(@NotNull long[] arr) {
        double sum = 0.0;

        for (long n : arr)
            sum += n;

        return (sum / arr.length);
    }

    @Contract(pure = true)
    public static double average(@NotNull double[] arr) {
        double sum = 0.0;

        for (double n : arr)
            sum += n;

        return (sum / arr.length);
    }

    public static double average(@NotNull List<? extends Number> list) {
        double sum = 0.0;
        if (list.isEmpty())
            return sum;

        for (Number n : list)
            sum += n.doubleValue();

        return (sum / list.size());
    }

    public static double average(@NotNull Map<?, ? extends Number> map) {
        final double[] sum = new double[1];
        sum[0] = 0.0;
        if (map.isEmpty())
            return sum[0];

        map.forEach((key, value) -> sum[0] += value.doubleValue());

        return (sum[0] / map.size());
    }

    public static double average(@NotNull float[] arr) {
        double sum = 0.0;

        for (float n : arr)
            sum += n;

        return (sum / arr.length);
    }

    public static double random() {
        return Silvester.RandomNumberGeneratorHolder.randomNumberGenerator.nextDouble();
    }

    public static double random(double bound) {
        return random() * bound;
    }

    public static double random(double a, double b) {
        double max = max(a, b);
        double min = min(a, b);
        return random() * (max - min) + min;
    }

    public static int randomInt() {
        return round((float) random());
    }

    public static int randomInt(int bound) {
        return round((float) random(bound));
    }

    public static int randomInt(double a, double b) {
        return round((float) random(a, b));
    }

    public static int noiseInt(double prev) {
        return randomInt(prev - 3, prev + 3);
    }

    public static double noise(double prev) {
        return random(prev - 3, prev + 3);
    }

    public static double exp(double d) {
        return StrictMath.exp(d);
    }


    //Neural Network
    @Contract(pure = true)
    public static double signum(double d) {
        return StrictMath.signum(d);
    }

    @Contract(pure = true)
    public static float signum(float f) {
        return StrictMath.signum(f);
    }

    public static double sigmoid(double d) {
        return 1d / (1 + Math.exp(-d));
    }

    public static double hyperbolicTangent(double d) {
        return StrictMath.tanh(d);
    }

    public static double tanh(double d) {
        return hyperbolicTangent(d);
    }

    @Contract(pure = true)
    public static double rectify(double d) {
        return max(0, d);
    }


    // Geometric
    @Contract(pure = true)
    public static double volume(double width, double length, double height) {
        return width * length * height;
    }

    @Contract(pure = true)
    public static double surface(double width, double length) {
        return width * length;
    }

    public static double cylinderSurface(double radius, double height) {
        return (circular(radius) * 2) + (circumference(radius) * height);
    }

    public static double cylinderVolume(double radius, double height) {
        return circular(radius) * height;
    }

    @Contract(pure = true)
    public static double circumference(double radius) {
        return (radius * 2) * PI;
    }

    public static double circular(double radius) {
        return (pow(radius, 2)) * PI;
    }

    public static double rectangleSurface(double width, double length, double height) {
        return ((surface(width, length) * 2) + (surface(width, height) * 2) + (surface(length, height) * 2));
    }

    @Contract(pure = true)
    public static double rectangleVolume(double width, double length, double height) {
        return volume(width, length, height);
    }


    // Velocities
    @Contract(pure = true)
    public static double kmh2mph(double kmh) {
        return (kmh / 1.609);
    }

    @Contract(pure = true)
    public static double mph2kmh(double mph) {
        return (mph * 1.609);
    }

    @Contract(pure = true)
    public static double mph2knots(double mph) {
        return (mph / 1.151);
    }

    @Contract(pure = true)
    public static double knots2mph(double knots) {
        return (knots * 1.151);
    }

    @Contract(pure = true)
    public static double kmh2knots(double kmh) {
        return (kmh / 1.852);
    }

    @Contract(pure = true)
    public static double knots2kmh(double knots) {
        return (knots * 1.852);
    }

    @Contract(pure = true)
    public static double kmh2mps(double kmh) {
        return (kmh / 3.6);
    }

    @Contract(pure = true)
    public static double mps2kmh(double mps) {
        return (mps * 3.6);
    }

    @Contract(pure = true)
    public static double mph2mps(double mph) {
        return (mph / 2.237);
    }

    @Contract(pure = true)
    public static double mps2mph(double mps) {
        return (mps * 2.237);
    }


    // Temperatures
    @Contract(pure = true)
    public static double celsius2fahrenheit(double celsius) {
        return ((celsius * 9 / 5) + 32);
    }

    @Contract(pure = true)
    public static double celsius2kelvin(double celsius) {
        return (celsius + 273.15);
    }

    public static double fahrenheit2kelvin(double fahrenheit) {
        return celsius2kelvin(fahrenheit2celsius(fahrenheit));
    }

    @Contract(pure = true)
    public static double fahrenheit2celsius(double fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }

    @Contract(pure = true)
    public static double kelvin2celsius(double kelvin) {
        return (kelvin - 273.15);
    }

    public static double kelvin2fahrenheit(double kelvin) {
        return celsius2fahrenheit(kelvin2celsius(kelvin));
    }

    private static final class RandomNumberGeneratorHolder {
        static final Random randomNumberGenerator = new Random();

        private RandomNumberGeneratorHolder() {
        }
    }
}
