import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the seed for our fibonacci");
        int seed = scanner.nextInt();
        System.out.println("The fibonacci of " + seed + " is = "+ Fibonacci.result(seed));
    }
}