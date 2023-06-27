package Practice.classSample;

public class CodingBat {
    public static void main(String[] args) {
//        System.out.println(nearHundred(89));
//        String str = "kitten";
//        int n= 0;
//        String front = str.substring(0 , n);
//        String end = str.substring(n+1 , str.length());

//        System.out.println(front+end);
//        loneTeen(16, 17);
//        delDel("adelbc");
//        delDel("add");
//        System.out.println(loneTeen(16, 17));
        StringBuilder sb = new StringBuilder();
//        int[] arr = {1, 1, 2, 1, 2, 3};
        int[] arr = {1, 1, 2, 2, 1};
//        arrayFront9(arrayFront);
        CodingBatSolution cbs = new CodingBatSolution();

//        System.out.println("array123 = " + cbs.array123(arr));
//        System.out.println("altPairs = " + cbs.altPairs("kitten"));
//        System.out.println("altPairs = " + cbs.altPairs("Chocolate"));
//        System.out.println(cbs.noTriples(arr));
//        System.out.println(cbs.stringMatch("abc", "abc"));
//        System.out.println(cbs.stringMatch("xxcaazz", "xxbaaz"));
//        System.out.println(cbs.stringMatch("xxcaazz", "xxbaaz"));
        //cbs.middleThree("solving");
//        cbs.middleThree("Candy");
        //System.out.println(cbs.withoutX2("xHi"));
//        System.out.println(cbs.twoChar("java", 0));
//        System.out.println(cbs.twoChar("java", 2));
//        System.out.println(cbs.twoChar("java", 3));
//        String[] s = {"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"};
//        cbs.allSwap(s);
        //;
//        System.out.println(cbs.greenTicket(0,1,1));
//        System.out.println(cbs.greenTicket(1,0,1));
//        System.out.println(cbs.inOrderEqual(1,2,3, false));
//        System.out.println(cbs.lastDigit(23, 19, 13));
//        System.out.println(cbs.makeBricks(6,1,11));
//        System.out.println(cbs.makeBricks(7,1,13));
//        System.out.println(cbs.makeChocolate(4, 1, 4));
//        System.out.println(cbs.roundSum(16, 17, 18));
//        System.out.println(cbs.closeFar(10, 10, 8) );
//        System.out.println(cbs.closeFar(8, 6, 9) );
//        System.out.println(cbs.closeFar(8, 6, 9) );
//        System.out.println(cbs.closeFar(1, 2, 3) );
//        System.out.println(cbs.countCode("codexxcode") );
//        System.out.println(cbs.xyzMiddle("AxyzBB") );
//        System.out.println(cbs.xyzMiddle("AAxyzB") );
//        System.out.println(cbs.catDog("catdog") );
        System.out.println(cbs.xyBalance("x"));

        System.out.println("yey");

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
        /*if(!str.substring(1,4).equals("del")) {
            return str;
        }
        String []s = str.split("del");*/
//        return s[0]+s[1];
        return "";
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

    public static boolean arrayFront9(int[] nums) {
        boolean flag = false;
        int size = Math.min(nums.length, 4);
        for(int x =0; x < size; x++) {
            if(nums[x] == 9) {
                flag = true;
                x=9;
            }
        }
        return flag;
    }




}
