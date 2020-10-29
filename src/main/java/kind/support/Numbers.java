package kind.support;

import kind.support.collections.Arrays;
import java.util.Random;

public class Numbers {

    private static final Random random = new Random();

    private Numbers() {
    }

    /**
     * Returns if the given number is a odd number<br/>
     * Example<br/>
     * isOdd(-1) returns true<br/>
     * isOdd(0) returns false<br/>
     * isOdd(1) returns true<br/>
     * isOdd(2) returns false<br/>
     *
     * @param number
     * @return
     * @see Numbers#isEven is the inverse
     */
    public static boolean isOdd(int number) {
        return (number % 2 != 0);
    }

    /**
     * Returns if the given number is a odd number<br/>
     * Example<br/>
     * isOdd(-1) returns false<br/>
     * isOdd(0) returns true<br/>
     * isOdd(1) returns false<br/>
     * isOdd(2) returns true<br/>
     *
     * @param number
     * @return
     * @see Numbers#isOdd is the inverse
     */
    public static boolean isEven(int number) {
        return (number % 2 == 0);
    }

    /**
     * Returns a random {@code int} between the given {@code min} and {@code max} values
     *
     * @param min
     * @param max
     * @return a random {@code int} between the given {@code min} and {@code max} values
     */
    public static int random(int min, int max) {
        final int n = max - min + 1;
        int i = random.nextInt() % n;
        if (i < 0) {
            i = -i;
        }
        return min + i;
    }

    /**
     * Returns a random {@code int} beteen the minimum and maximum value of a {@code int}
     *
     * @return
     */
    public static int random() {
        return random(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Returns a random {@code int} between the minimum and maximum value that is not contained within the
     * given exclusions array. A maximum of  1,000,000 tries will throw a ArithmeticException.
     *
     * @param min
     * @param max
     * @param exclusions
     * @return
     * @throws ArithmeticException
     */
    public static synchronized int random(int min, int max, int[] exclusions) throws ArithmeticException {

        int i = 0;
        final int maxAttempts = 1000000;

        while (i < maxAttempts) {
            final int candidate = random(min, max);

            if (!Arrays.contains(exclusions, candidate)) {
                return candidate;
            }
        }

        throw new ArithmeticException("Cannot  generate a random number in the given range of exclusions");
    }
}
