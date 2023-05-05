package Practice.classSample;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class SplitSample {
    public static void main(String[] args) {
        String string = "dog, cat, horse";
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(",");
//        Collections.sort(arr);
        Arrays.sort(arr);
        for(String s: arr) {
            System.out.println(s.trim());
        }
    }
}
