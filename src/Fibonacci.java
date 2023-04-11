public class Fibonacci {
    public static int result(int seed) {

        if (seed <= 1 ) {
            return seed;
        }
        return result(seed -1 ) + result(seed - 2);

    }
}
