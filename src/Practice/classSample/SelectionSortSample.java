package Practice.classSample;

public class SelectionSortSample {
    public static void main(String[] args) {
        double[][] sales = {
                {10,11,12,13},
                {14,15,16,17},
                {18,19,20,21}
        };
        System.out.println(sales.length);
        double grand_total = 0.0;
        for(double[] d1 : sales) {
            for(double d2 : d1) {
              grand_total+=d2;
            }
        }

        System.out.printf("the grand total is : $%.2f\n", grand_total);

        final int year = 2021;

        for(int row=0; row<sales.length; row++) {
            double yearly_total = 0.0;
            for(int col=0; col<sales[row].length;col++) {
                yearly_total+= sales[row][col];
            }
            System.out.printf("The total yearly sale for the year %d is $%.2f\n", year+row, yearly_total);
        }

        for(int col=0; col<sales[0].length;col++) {
            double quarterly_total = 0.0;
            for(int row=0; row<sales.length; row++) {
                quarterly_total+= sales[row][col];
            }
            System.out.printf("The quarterly sale for the Q%d is $%.2f\n", col, quarterly_total);
        }


    }
}
