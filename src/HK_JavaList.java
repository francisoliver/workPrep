import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HK_JavaList {
    public static void main(String[] args) {

        final Scanner in = new Scanner(System.in);
        final int size = in.nextInt();
        final List<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(in.nextInt());
        }
        final int commandCount = in.nextInt();
        for (int i = 0; i < commandCount; i++) {
            in.nextLine();
            String command = in.nextLine();
            int index = in.nextInt();
            if (command.equals("Insert")) {
                int value = in.nextInt();
                list.add(index, value);
            } else {
                list.remove(index);
            }
        }

        list.forEach(l -> System.out.print(l + " "));
        in.close();

    }
}
