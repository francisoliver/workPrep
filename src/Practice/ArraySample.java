package Practice;

public class ArraySample {
    public static void main(String[] args) {

        int arr[] = new int[5];
        arr[0] = 1;
        arr[1] = 10;
        arr[2] = 110;
        arr[3] = 11110;
        arr[4] = 111110;

        for(int i : arr) {
            System.out.println(i);
        }

        //multi

        int[][] multi = {
                {1,2,3}, {4,5,6}, {7,8,9},{10}
        };

        System.out.println(multi[0].length);
        System.out.println(multi[1].length);
        System.out.println(multi[2].length);
        System.out.println(multi[3].length);


        //swap var

        int first = 3, second = 5;

        first = first + second;
        second = first - second;
        first = second - first;

        System.out.println("first " + first);
        System.out.println("second " + second);




    }
}
