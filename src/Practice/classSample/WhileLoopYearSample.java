package Practice.classSample;

import java.util.Scanner;

public class WhileLoopYearSample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter year!");
        System.out.println("Else, please enter 0 to quit!");
        int years = scanner.nextInt();
        while(years != 0) {
            if(isLeapYear(years)) {
                System.out.format("\nHi, the year %s is consider as leap year!", years);
            } else {
                System.out.format("\nHi, the year %s is not consider as leap year!", years);
            }
            System.out.println("\nEnter another year, or zero to quit:");
            years = scanner.nextInt();
        }
        System.out.println("Goodbye!");
    }

    private static boolean isLeapYear(int years) {
        return ((years % 4 == 0 && years % 100 != 0) || years % 400 == 0);
    }
}
