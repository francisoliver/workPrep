public class Fibonacci {
    public static int result(int seed) {

        if (seed <= 1 ) {
            return seed;
        }
        return result(seed -1 ) + result(seed - 2);

    }

    public static int series(int seed, int x, int y) {

        if(seed == 1) {
            return x;
        }

        if(seed == 2) {
            return y;
        }

        int sum = x + y;

        for(int index = 3; index < seed; index++) {
            x = y;
            y = sum;
            sum = x + y;
        }

        return sum;
    }

}
