package Practice;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    static boolean compute(String string1, String string2) {

//        string1.codePoints().mapToObj(Character::toChars)
//                .forEach(System.out::println);
        if(string1.length() != string2.length()) return false;
        
        char [] charsA = string1.toCharArray();
        char [] charsB = string2.toCharArray();

        Arrays.sort(charsA);
        Arrays.sort(charsB);
        
        return Arrays.equals(charsA, charsB);

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String string1 = scanner.nextLine().replaceAll(" ", "");
        String string2 = scanner.nextLine().replaceAll(" ", "");

        if(compute(string1, string2)) {
            System.out.println("yes " + string1 + " and " + string2 +  " are anagram");
        } else {
            System.out.println("no " + string1 + " and " + string2 +  " are not anagram");
        }
    }
}
