package Practice.classSample;

import java.util.Scanner;

public class SampleUsingFormat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the price $ ");
        double price = scanner.nextDouble();
        double discountedPrice = price * 0.85;
        System.out.format("Your price is $%.2f after 15%% discount.\n", discountedPrice);

    }

}
