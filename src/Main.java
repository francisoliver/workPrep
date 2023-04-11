import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the seed for our fibonacci");
        int seed = scanner.nextInt();
        //System.out.println("The fibonacci of " + seed + " is = "+ Fibonacci.result(seed));

        System.out.println("Please enter the first number for our fibonacci series");
        int x = scanner.nextInt();
        System.out.println("Please enter the second number for our fibonacci series");
        int y = scanner.nextInt();

        System.out.println("The fibonacci series of seed " + seed + " with first number " + x +" and second number " + y +" is " + Fibonacci.series(seed, x , y));

    }
}