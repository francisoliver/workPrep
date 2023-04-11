import javax.imageio.ImageTranscoder;
import java.util.*;
public class Solution {
    public static void main(String args[]) {

    System.out.println("GCD of "+ 24 + " " + 46 +" is = " + getGcd(24, 46));
    System.out.println("GCD of "+ 18 + " " + 42 +" is = " + getGcd(18, 42));

    System.out.println("GCD of "+ 24 + " " + 46 +" is = " + getGcd(24, 46));
    System.out.println("GCD of "+ 18 + " " + 42 +" is = " + getGcd(18, 42));

    factTest(4, 16,96);

    }

    public static int getGcd(int a, int b) {
        return (b == 0) ? a : getGcd(b, a % b);
    }

    public static int getLcm(int a, int b) {
        if( a == 0 || b == 0) {
            return 0;
        } else {
            return Math.abs(a * b) / getGcd(a, b);
        }
        //return a / getGcd(a,b) * b;
    }

    public static void factTest(int start, int end, int num) {

        for( int index = start; index <= end; index++) {
            if(num % index == 0) {
                System.out.println(index);
            }
        }

    }

    public int getTotalX(List<Integer> a, List<Integer> b) {
        int result = 0;

        // Get LCM of all elements of a
        int lcm = a.get(0);
        for (Integer integer : a) {
            lcm = getLcm(lcm, integer);
        }

        // Get GCD of all elements of b
        int gcd = b.get(0);
        for (Integer integer : b) {
            gcd = getGcd(gcd, integer);
        }

        // Count multiples of lcm that divide the gcd
        int multiple = 0;
        while (multiple <= gcd) {
            multiple += lcm;

            if (gcd % multiple == 0)
                result++;
        }

        return result;
    }

}
