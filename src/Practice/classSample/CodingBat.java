package Practice.classSample;

public class CodingBat {
    public static void main(String[] args) {
    System.out.println(nearHundred(89));
    String str = "kitten";
    int n= 0;
    String front = str.substring(0 , n);
    String end = str.substring(n+1 , str.length());

    System.out.println(front+end);
    loneTeen(16, 17);
    delDel("adelbc");
    delDel("add");
    System.out.println(loneTeen(16, 17));
    StringBuilder sb = new StringBuilder();

    }

    public static boolean nearHundred(int n) {
        return ((Math.abs(100 - n) <= 10) ||
                (Math.abs(200 - n) <= 10));
    }

    public static boolean loneTeen(int a, int b) {
        if(13==a && 13==b) return false;
        return isTeen(a)||isTeen(b);
    }


    public static boolean isTeen(int a){
        return a>12&&a<20;
    }

    public static String delDel(String str) {
        if(!str.substring(1,4).equals("del")) {
            return str;
        }
        String []s = str.split("del");
        return s[0]+s[1];
    }

    public static int countXX(String str) {
        int counter = 0;
        for(int n = 0; n < str.length() - 1; n++) {
            if(str.substring(n, n + 2).equals("xx")) {
                counter++;
            }
        }
        return counter;
    }

    public static int last2(String str) {
        int count  = 0;
        int len = str.length();
        String end = str.substring(len - 2, len);

        for(int n =0; n< len -2; n++) {
            if(str.substring(n, n+2).equals(end)) count++;
        }
        return count;
    }



}
