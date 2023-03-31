
    import java.util.*;

    public class HK_JavaListSolution {

        public static void main(String[] args) {
            List<Integer> list = new LinkedList<>();
            Scanner scanner = new Scanner(System.in);

            int limit = scanner.nextInt();

            for (int i = 0; i < limit; i++) {
                list.add(scanner.nextInt());
            }

            int queries = scanner.nextInt();

            for (int i = 0; i < queries; i++) {
                String query = scanner.next();

                switch (query) {
                    case "Insert" -> {
                        int index = scanner.nextInt();
                        int value = scanner.nextInt();
                        list.add(index, value);
                    }
                    case "Delete" -> {
                        int removeIndex = scanner.nextInt();
                        list.remove(removeIndex);
                    }
                }
            }

            list.forEach(l -> System.out.print(l + " "));

            scanner.close();
        }
    }

