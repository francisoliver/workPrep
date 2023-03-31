import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HK_JavaList {
    public static void main(String[] args) {

        final Scanner in = new Scanner(System.in);
        final int size = in.nextInt();
//        System.out.println("Size is = " +size);
        final List<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(in.nextInt());
        }
        final int commandCount = in.nextInt();
//        System.out.println("commandCount: " + commandCount);
        for (int i = 0; i < commandCount; i++) {
            in.nextLine();
            String command = in.nextLine();
//            System.out.println("command: " + command);
            int index = in.nextInt();
            if (command.equals("Insert")) {
//                System.out.println("index: " + index);
                int value = in.nextInt();
//                System.out.println("value: " + value);
                list.add(index, value);
            } else {
                list.remove(index);
            }
        }

        list.forEach(l -> System.out.print(l + " "));
        in.close();

    }
}
