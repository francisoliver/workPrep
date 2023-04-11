import java.util.Scanner;

public class ScannerReview {


    public static void main(String args[]) {

        System.out.println("hello Scanner Review!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, what is your name?");
        String name = scanner.nextLine();
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What is your favorite food?");
        String food = scanner.nextLine();


        Person person = new Person(name, age, food);


        //System.out.println("Hello there!, my name is " + person);
        person.print();



    }




}
