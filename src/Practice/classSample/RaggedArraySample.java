package Practice.classSample;

public class RaggedArraySample {
    public static void main(String[] args) {
        int [][] choices = {
                {9},
                {7, 5},
                {4, 6, 1},
                {3, 1, 2, 8},
        };

        int people = 0;
        for(int row = 0; row<choices.length; row++) {
            for(int col = 0; col< choices[row].length; col++) {
                people+= choices[row][col];
            }
        }
        System.out.println(people);
    }
}
