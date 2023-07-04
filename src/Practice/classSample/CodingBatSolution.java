package Practice.classSample;

import java.util.*;
import java.util.stream.Collectors;

public class CodingBatSolution {
    public boolean array123(int[] nums) {
        int len = nums.length;
        if(len < 3) return false;
        for(int n = 0; n < len - 2; n++) {
            if(1 == nums[n] && 2 == nums[n + 1] && 3 == nums[n+2]) {
                return true;
            }
        }
        return false;
    }

    public String altPairs(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for(int n = 0; n < len ; n+=4) {
            int end = Math.min(2, len - n);
            sb.append(str.substring(n, n + end));
        }
        return sb.toString();
    }

    public boolean noTriples(int[] nums) {
        int n = 0, len = nums.length;
        boolean hasTriples = true;
        do {
            if(nums[n] == nums[n+1] && nums[n] == nums[n+2]) {
                hasTriples = false;
                n = len;
            }
            n++;
        } while (n < len -2);
        return hasTriples;
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for(int n : nums) {
//            if(!map.containsKey(n)) {
//                map.put(n, 1);
//            } else {
//                map.put(n, map.get(n).intValue() +1);
//            }
//        }
//        System.out.println(map);
//        return !map.containsValue(3);
    }

    public int stringMatch(String a, String b) {
        String s,l;
        if(a.length() > b.length()) {
            l = a;
            s =b;
        } else {
            l = b;
            s = a;
        }
        int count = 0;
        for(int n = 0; n < a.length() -1; n++) {
            int size = Math.min(Math.min(l.length() - n , s.length() -n), 2);
            if(size < 2) break;
            if(l.substring(n, n + size).equals(s.substring(n, n + size))) {
                count++;
            }
        }
        return count;
    }
    public String twoChar(String str, int index) {
        int len = str.length();
        int offset = len >= index + 2  ? index : 0;
        if(index < 0) offset = 0;
        return str.substring(offset, offset +2);
    }

    public String middleThree(String str) {

        int len = str.length();
        int offset = (len - 3) / 2;
        if(len == 3) return str;
        StringBuilder sb = new StringBuilder(str);
        return sb.delete(len - offset, len).delete(0, offset).toString();

    }

    public String startWord(String str, String word) {
        int len = word.length();

        String firstWord = str.substring(0, len);
        if(firstWord.equals(word)) {
            return firstWord;
        }
        System.out.println(firstWord);
        String secondChance = str.substring(1, len);
        System.out.println(secondChance);
        String x = firstWord.substring(1);
        if(x.equals(word.substring(1))) {
            return firstWord;
        }
        return "";
    }

    public String without2(String str) {
        if(str.length()< 2) return str;
        StringBuilder output = new StringBuilder(), sb = new StringBuilder();
        sb.append(str.substring(0, 2));
        if(str.endsWith(sb.toString())) {
            output.append(str.substring(2));
            output.append(sb.substring( 0, sb.length() - 2));
            return output.toString();
        }
        return str;
    }

    public String minCat(String a, String b) {
        int lenA = a.length(), lenB = b.length(), diff = 0;
        if(lenA == lenB) {
            return a +  b;
        } else if(lenA> lenB) {
            diff = lenA - lenB;
            return a.substring(diff, lenA)+ b;
        } else {
            diff = lenB - lenA;
            return a + b.substring(diff, lenB);
        }
    }

    public String withoutX(String str) {
        StringBuilder sb = new StringBuilder();
        String x = "x";
        if(str.endsWith(x)) {
            sb.append(str.substring(0, str.length() - 1));
        } else sb.append(str);
        if(str.startsWith(x)) {
            return sb.delete(0, 1).toString();
        } else return sb.toString();
    }

    public String withoutX2(String str) {
        if(str.length()<2) return "";
        String x = "x";
        StringBuilder sb = new StringBuilder(str);

        if(str.substring(1,2).equals(x)) {
            sb.delete(1,2);
        }

        if(str.startsWith(x)) {
            sb.delete(0,1);
        }

        return sb.toString();
    }
    public int maxTriple(int[] nums) {
        int last = nums.length -1, mid = nums.length / 2, max = 0;
        max = Math.max(nums[0] , nums[mid]);
        return nums[last] > max ? last :max;
    }

    public int[] maxEnd3(int[] nums) {
        int max = Math.max(nums[0], nums[nums.length - 1]);
        Arrays.fill(nums,max);
        return nums;
    }

    public Map<String, String> topping1(Map<String, String> map) {
        if(map.containsKey("ice cream")) {
            map.put("ice cream", "cherry");
        }
        map.put("bread", "butter");
        return map;
    }
    public Map<String, String> topping2(Map<String, String> map) {
        if(map.containsKey("ice cream")) {
            map.put("yogurt", map.get("ice cream"));
        }
        if(map.containsKey("spinach")) {
            map.put("spinach", "nuts");
        }
        return map;
    }
    public Map<String, String> mapAB3(Map<String, String> map) {
        if(map.containsKey("a") ^ map.containsKey("b")) {
            if(map.containsKey("a")) {
                map.put("b", map.get("a"));
            } else if (map.containsKey("b")) {
                map.put("a", map.get("b"));
            }
        }
        return map;
    }

    public Map<String, String> mapBully(Map<String, String> map) {
        String a = "a", b = "b";
        if(map.containsKey(a)) {
            map.put(b, map.get(a));
            map.put(a, "");
        }
        return map;
    }
    public Map<String, String> mapAB(Map<String, String> map) {
        String a = "a", b = "b";
        if(map.containsKey(a) && map.containsKey(b)) {
            map.put("ab", map.get(a)+map.get(b));
        }
        return map;
    }
    public Map<String, String> topping3(Map<String, String> map) {
        // key potato has value -> set this values as fries
        // key salad has value -> set this values as spinach
        if(map.containsKey("potato")) {
            map.put("fries", map.get("potato"));
        }
        if(map.containsKey("salad")) {
            map.put("spinach", map.get("salad"));
        }
        return map;
    }
    public Map<String, String> mapShare(Map<String, String> map) {
        if(map.containsKey("a")) {
            map.put("b", map.get("a"));
        }
        map.remove("c");
        return map;
    }

    public Map<String, String> mapAB2(Map<String, String> map) {
        if(map.containsKey("a")&&map.containsKey("b") && map.get("a").equals(map.get("b"))) {
            map.remove("a");
            map.remove("b");
        }
        return map;
    }

    public Map<String, String> mapAB4(Map<String, String> map) {
        if(map.containsKey("a")&&map.containsKey("b")) {
            String a = map.get("a"), b = map.get("b");
            String result = "";
            if(a.length()>b.length()) {
                result = a;
            } else if (a.length()<b.length()) {
                result = b;
            } else if(a.length() == b.length()) {
                map.put("a", "");
                map.put("b", "");
            }
            if(result.length()>0) map.put("c", result);
        }
        return map;
    }

//map 2 activity

    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for(String x : strings) {
            if(map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        return map;
    }

    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for(String x : strings) {
            map.put(x, x.length());
        }
        return map;
    }

    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for(String x : strings) {
            int len = x.length();
            map.put(x.substring(0,1), x.substring(len -1));
        }
        return map;
    }

    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for(String x : strings) {
            if(map.containsKey(x)) {
                map.put(x, true);
            } else map.put(x, false);
        }
        return map;
    }
    public String[] allSwap(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        for (int n = 0; n < strings.length; n++) {
            String x = strings[n].substring(0,1);
            if(!map.containsKey(x)) {
                map.put(x, n);
            } else {
                int i = map.get(x);
                String swap = strings[i];
                strings[i] = strings[n];
                strings[n] = swap;
                map.remove(x);
            }
        }
        System.out.println(map);
        return strings;
        //"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"
        //"ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"
        //"ay", "by", "cy", "cx", "bx", "ax", "azzz", "axx"
    }


    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for(String s: strings) {
            map.put(s, 0);
        }
        return map;
    }

    public String wordAppend(String[] strings) {

        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for(String s: strings) {
            if(map.containsKey(s)) {
                int count = map.get(s);
                if (count % 2 == 1) {
                    stringBuilder.append(s);
                }
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        return stringBuilder.toString();
    }

    public String[] firstSwap(String[] strings) {
        Map<Character, Integer> map = new HashMap<>();
        for (int n = 0; n < strings.length; n++) {
            char x = strings[n].charAt(0);
            if(!map.containsKey(x)) {
                map.put(x, n);
            } else {
                int i = map.get(x);
                if(i>=0) {
                    String swap = strings[i];
                    strings[i] = strings[n];
                    strings[n] = swap;
                    map.put(x, -1);
                }
            }
        }
        return strings;
    }

    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();

        for (String s: strings) {
            String firstChar = s.substring(0, 1);
            if(map.containsKey(firstChar)) {
                map.put(firstChar, map.get(firstChar) + s);
            } else {
                map.put(firstChar, s);
            }
        }
        return map;
    }

    public int greenTicket(int a, int b, int c) {
        if(a!=b && b!=c && a!=c) return 0;
        if(a==b&&b==c) return 20;
        if(a==b || b==c||a == c) {
            return 10;
        }
        return 0;
    }
    public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
        boolean res = false;
        if(!equalOk) {
            if(a<b&&b<c) {
                res = true;
            }
        } else {
            if(a<=b&&b<=c) {
                res = true;
            }
        }

        return res;
    }

    public boolean lastDigit(int a, int b, int c) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] x = {a%10, b%10,c%10};
        for(int n: x) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }

        }
        return map.containsValue(2); 
    }

    public int matchUp(String[] a, String[] b) {
        int len = a.length, ctr = 0;
        for(int n=0; n< len;n++) {
            if(a[n].length()>0 && b[n].length()>0 ) {
                char x = a[n].charAt(0), y = b[n].charAt(0);
                if(x==y) ctr++;
            }
        }
        return ctr;
    }
//todo:

    public boolean makeBricks(int small, int big, int goal) {

        int currentValue = 0;
            int Q = goal / 5;
            if(Q <= big) {
                currentValue += Q * 5;
                int R = goal % currentValue;
                if(R <= small) {
                    currentValue+= R;
                }
            } else {
                currentValue = big * 5;
                int diff = goal - currentValue;
                if(diff <= small) {
                    currentValue += diff;
                }
            }
        return currentValue == goal;
    }

    public int loneSum(int a, int b, int c) {
        Map<Integer, Boolean > map = new HashMap<>();
        int[] arr = {a, b, c};
        for (int n :arr) {
            if(map.containsKey(n)) {
                map.put(n, false);
            } else {
                map.put(n, true);
            }
        }
        int output = 0;

        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            Integer k = entry.getKey();
            Boolean v = entry.getValue();
            if(v) {
                output+=k;
            }
        }
        return output;
    }

    public int makeChocolate(int small, int big, int goal) {

        int bigTotal = big * 5;
        while (bigTotal > goal) {
            bigTotal -= 5;
        }
        int amount = goal - bigTotal;
        if (amount <= small) {
            return amount;
        }
        else {
            return -1;
        }
    }


    public boolean evenlySpaced(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        return arr[0] - arr[1] == arr[1] - arr[2];
    }

    public int luckySum(int a, int b, int c) {
        int[] arr = {a, b, c};
        int sum = 0;
        boolean flag13 = false;
        for(int n : arr) {
            if(13 == n) flag13 = true;
            if(!flag13) {
                sum += n;
            }
        }
        return sum;
    }

    public int roundSum(int a, int b, int c) {
        int[] arr = {a, b, c};
        int sum = 0;
        for(int n: arr) {
            sum += round10(n);
        }
        return sum;
    }
    public int round10(int number) {
        int remainder = number % 10;
        if(remainder < 5) {
            return number - remainder;
        }
        return (number  - remainder) + 10;
    }


    public int noTeenSum(int a, int b, int c) {
        int[] arr = {a, b, c};
        int sum = 0;
        for(int n: arr) {
            sum += fixTeen(n);
        }
        return sum;
    }

    public int fixTeen(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(13);
        set.add(14);
        set.add(17);
        set.add(18);
        set.add(19);
        return set.contains(n) ? 0: n;
    }

    public boolean closeFar(int a, int b, int c) {
        int ab = Math.abs(a - b), ac = Math.abs(a - c);
        if(ab <= 1) {
            return Math.abs(a - c) >= 2 && Math.abs(b - c) >= 2;
        }
        if(ac <= 1) {
            return Math.abs(a - b) >= 2 && Math.abs(b - c) >= 2;
        }
        return false;
    }
    public int countCode(String str) {
        str = str.toLowerCase();
        int codeCount = 0, len = str.length();
        for(int ctr =0; ctr < len - 3; ctr++) {
            String _str = str.substring(ctr, ctr + 4);
            if(_str.startsWith("co") &&_str.endsWith("e")) {
                codeCount++;
            }
        }
        return codeCount;
    }

    public boolean xyzMiddle(String str) {
        String xyz = "xyz";
        int len = str.length(),mid = (len / 2);
        if(len < 3) return false;
        boolean b = str.substring(mid - 1).startsWith(xyz);
        if(len % 2 == 1) {
            return b;
        }
        //odd
        if(str.substring(mid - 2).startsWith(xyz)) {
            return true;
        }
        return b;

    }

    public boolean catDog(String str) {
        String dog = "dog", cat = "cat";
        int len = str.length(), dogCount = 0, catCount = 0;
        for(int ctr = 0; ctr < len - 2; ctr++) {
            String animal = str.substring(ctr, ctr + 3);
            if(animal.equals(dog)) {
                dogCount++;
            }
            if(animal.equals(cat)) {
                catCount++;
            }
        }
        return dogCount == catCount;
    }

    public String zipZap(String str) {

        int len = str.length();
        StringBuilder sb = new StringBuilder();
        int ctr = 0;
        while(ctr < len) {
            String s = "", append = "";
            int x = 0;
            if(ctr + 2 < len) {
                x = 3;
            } else {
                x = 1;
            }
            s = str.substring(ctr, ctr + x);
            if(s.startsWith("z") && s.endsWith("p")) {
                append = "zp";
                ctr+=3;
            } else {
                ctr++;
                append = s.substring(0, 1);
            }
            sb.append(append);
        }
        return sb.toString();
    }
    public boolean xyBalance(String str) {
        if(str=="x") return false;
        int ctr = 0;
        int indexOfX  = 0, len = str.length(), indexOfY = 0;

        while(ctr < len) {
            str = str.substring(ctr);
            indexOfX = str.indexOf("x");
            if(indexOfX > - 1 ) {
                str = str.substring(indexOfX +1);
                indexOfY = str.indexOf("y");
                if(indexOfY > -1) {
                    ctr = indexOfY + 1;
                } else {
                    ctr = len + 1;
                }
            } else {
                ctr = len + 1;
            }
        }
        return indexOfY > indexOfX && indexOfY!= -1;
    }

    public String oneTwo(String str) {
        int len = str.length(), counter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (counter < len) {
            if(str.length()>=3) {
                stringBuilder.append(str.substring(1,3));
                stringBuilder.append(str.substring(0, 1));
                str = str.substring( 3);
            }
            counter+=3;
        }
        return stringBuilder.toString();
    }

    public String getSandwich(String str) {
        String bread = "bread";
        int start = str.indexOf(bread), end = str.lastIndexOf(bread);
        if(start == end) return "";
        return str.substring(start + bread.length(), end);
    }

    public String wordEnds(String str, String word) {

        StringBuilder newStr = new StringBuilder();

        for(int i = 0; i < str.length()-word.length()+1; i++){
            boolean equals = str.substring(i, i + word.length()).equals(word);
            if(i > 0 && equals)
                newStr.append(str.charAt(i-1));

            if(i < str.length()-word.length() && equals)
                newStr.append(str.charAt(i+word.length()));
        }

        return newStr.toString();
    }

    public boolean bobThere(String str) {
        int ctr = 0;
        String b = "b";
        while(ctr < str.length() - 2) {
            String s = str.substring(ctr, ctr + 3);
            if(s.startsWith(b) && s.endsWith(b)) {
                return true;
            }
            ctr++;
        }
        return false;
    }

    public String plusOut(String str, String word) {
        StringBuilder sb = new StringBuilder();
        int prev = 0, len = str.length();
        while(prev < len) {
            int index = str.indexOf(word);
            if(index == 0) {
                sb.append(word);
                prev = index + word.length();
            } else if(index > 0) {
                sb.append(createPlus(index)).append(word);
                prev = index + word.length();
            } else {
                sb.append(createPlus(str.length()));
                prev = len + 1;
            }
            if(prev > len) break;
            str = str.substring(prev);
        }

        return sb.toString();

    }
    public String createPlus(int i) {
        StringBuilder sb = new StringBuilder();
        while(i>0) {
            sb.append("+");
            i--;
        }
        return sb.toString();
    }

    public String repeatFront(String str, int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(str.substring(0, n));
            n--;
        }
        return sb.toString();
    }

    public int countHi(String str) {
        int numberOfHi = 0;
        while(str.contains("hi")) {
            str = str.substring(str.indexOf("hi") + 2);
            numberOfHi++;
        }
        return numberOfHi;
    }


    public String doubleChar(String str) {
        StringBuilder sb = new StringBuilder();
        for (char i : str.toCharArray()) {
            sb.append(i).append(i);
        }
        return sb.toString();
    }

    public String mixString(String a, String b) {

        StringBuilder sb = new StringBuilder();
        for(int index = 0; index < a.length() || index < b.length(); index++) {
            if(index < a.length()) {
                sb.append(a.substring(index, index + 1));
            }
            if(index < b.length()) {
                sb.append(b.substring(index, index + 1));
            }
        }

        return sb.reverse().toString();

    }

    public String starOut(String str) {
        Stack<Character> stack = new Stack<>();
        boolean shouldPop = true, previousAsterisk = false;
        for(char c: str.toCharArray()) {
            if(c == '*') {
                previousAsterisk = true;
                if(shouldPop) {
                    if(!stack.empty()){
                        stack.pop();
                    }
                    shouldPop = false;
                }
            }
            else {

              if(!previousAsterisk) {
                  stack.push(c);
                  shouldPop = true;
              }
            previousAsterisk = false;
            }
        }
        return stack.stream().map(s -> s.toString()).collect(Collectors.joining(""));
    }
    public String repeatEnd(String str, int n) {
        int counter = n;
        String s = str.substring(str.length() - n);
        StringBuilder stringBuilder = new StringBuilder();
        while(counter > 0) {
            stringBuilder.append(s);
            counter--;
        }
        return stringBuilder.toString();
    }

    public boolean sameStarChar(String str) {
        String pre = "", post ="";
        int len = str.length(), starCount = 0, matchCount = 0;
        if(!str.contains("*")) {
            return true;
        }
        for(int ctr =0; ctr< str.length() - 1; ctr++) {
            if(str.charAt(ctr) ==('*')) {
                starCount++;
                if( ctr > 0 ) {
                    pre = str.substring(ctr - 1, ctr );
                } else {
                    matchCount++;
                }
                if (ctr < len && pre.length() > 0 ) {
                    post = str.substring(ctr + 1, ctr + 2);
                    if(pre.equals(post)) {
                        matchCount++;
                    }
                    pre =""; post="";
                }
            }
        }

        return starCount == matchCount;
    }

    public boolean xyzThere(String str) {
        String xyz = "xyz";
        boolean xyzFound = false;
        if(!str.contains(xyz)) {
            return false;
        }
        for(int ctr = 0; ctr < str.length() -2; ctr++) {
            if(str.substring(ctr, ctr + 3).equals(xyz)) {
                if(!(ctr > 0 && str.charAt(ctr - 1) == '.')) {
                    xyzFound = true;
                }
            }
        }
        return xyzFound;
    }

    public int countEvens(int[] nums) {
        long l = Arrays.stream(nums)
                .filter(num -> num % 2 == 0)
                .count();
        return (int) l;
    }

    public boolean has12(int[] nums) {
        boolean numberOfOnes = false, numberOfTwos = false;
        for(int n : nums) {
            if(n == 1) {
                numberOfOnes = true;
            }
            if(n==2 && numberOfOnes) {
                numberOfTwos = true;
            }

        }
        return numberOfTwos;
    }

    public int sum13(int[] nums) {
        int sum = 0; boolean previous13 = false;
        for(int n : nums) {
            if(13 == n) {
                previous13 = true;
            } else if (previous13){
                previous13 = false;
            } else {
                sum+= n;
            }
        }
        return sum;
    }

    public int[] evenOdd(int[] nums) {
        int [] rev = new int[nums.length];
        int len = nums.length, ctrE = 0,ctrO = len -1;
            for(int n: nums) {
                if(n%2==0) {
                    rev[ctrE] = n;
                    ctrE++;
                } else  {
                    rev[ctrO] = n;
                    ctrO--;
                }
            }
            nums = rev;
        return nums;
    }
    public boolean isEverywhere(int[] nums, int val) {
        for(int ctr=0; ctr < nums.length - 1; ctr++) {
            if(nums[ctr] != val && nums[ctr+1]!=val) {
                return false;
            }
        }
        return true;
    }

    public String[] fizzArray2(int n) {
        String[] s = new String[n];
        for(int ctr = 0; ctr < n; ctr++) {
            s[ctr] = String.valueOf(ctr);
        }
        return s;
    }

    public int[] post4(int[] nums) {
        int indexOf4 = 0, ctr = nums.length - 1;
        while(ctr >= 0) {
            if(4 == nums[ctr]) {
                indexOf4 = ctr + 1;
                break;
            }
            ctr--;
        }
        int[] arr = new int[nums.length - indexOf4];
        for(int x = indexOf4, y=0; x < nums.length; x++, y++) {
            arr[y] = nums[x];
        }
        return arr;
    }

    public boolean sum28(int[] nums) {
        int sum = 0;
        for(int n: nums) {
            if(2 == n) {
                sum+=2;
            }
        }
        return 8 == sum;
    }

    public int[] fizzArray(int n) {
        int[] arr = new int[n];
        for(int ctr =0; ctr < n -1; ctr++) {
            arr[ctr] = ctr;
        }
        return arr;
    }

    public boolean tripleUp(int[] nums) {
        for(int ctr= 0; ctr < nums.length -2; ctr++) {
            if(nums[ctr] + 1 == nums[ctr +1 ] && nums[ctr] + 2 == nums[ctr + 2 ]) {
                return true;
            }
        }
        return false;
    }

    public boolean no14(int[] nums) {
        boolean oneFound = false, fourFound = false;
        for(int n: nums)   {
            if(n == 1 ) {
                oneFound = true;
            }
            if( n ==4 ) {
                fourFound = true;
            }
        }
        return (!(oneFound && fourFound));
    }
    public int matchUp(int[] a, int[] b) {
        int count = 0;

        for(int i = 0; i < a.length; i++) {
            int diff = Math.abs(a[i] - b[i]);
            if(diff > 0 && diff <2) {
                count++;
            }

        }

        return count;
    }

    public boolean haveThree(int[] nums) {
        int count = 0, len = nums.length;
        for(int ctr = 0; ctr < len; ctr++) {
            if(nums[ctr] == 3) {
                count++;
                if(ctr < len - 1) {
                    if(nums[ctr + 1]==3) {
                        return false;
                    }
                }
            }
        }

        return count == 3;

    }

    public boolean either24(int[] nums) {
        boolean prev2 = false,prev2b = false, prev4=false, prev4b=false;
        StringBuilder sb = new StringBuilder();
        for(int n: nums) {
            sb.append(n);
        }
        return sb.toString().contains("44") ^ sb.toString().contains("22");
    }

    public boolean twoTwo(int[] nums) {
        boolean prev2 = false, shouldBeTrue = false;
        if(nums.length == 1 && nums[0] == 2) return false;
        for(int ctr = 1; ctr < nums.length ; ctr++) {

            if(2 == nums[ctr]) {
                if(2 == nums[ctr - 1]) {
                    shouldBeTrue = false;
                } else {
                    shouldBeTrue = true;
                }
                prev2 = true;
            } else { //number is not 2 but check if the previous was 2, should it be true?
                if(prev2 && shouldBeTrue) {
                    return false;
                } else {
                    shouldBeTrue = false;
                }
            }

        }
        return !shouldBeTrue;
    }
    public boolean modThree(int[] nums) {
        int odd = 0, even = 0;
        for(int n: nums) {
            if(n % 2 == 0) {
                even++;
                odd= 0;
            } else {
                odd++;
                even =0;
            }
            if(3 == odd || 3 ==even) return true;
        }
        return false;
    }


    public int bigDiff(int[] nums) {
        Arrays.sort(nums);
        return Math.abs(nums[0] - nums[nums.length - 1]);
    }

    public int sum67(int[] nums) {
        boolean flag = true;
        int sum = 0;
        for(int n: nums) {
            if (6 == n) {
                flag = false;
            }

            if(flag) {
                sum+= n;
            }

            if (7 == n) {
                flag = true;
            }
        }
        return sum;
    }

    public int[] pre4(int[] nums) {
        int indexOf4 = 0, start = 0;
        for(int ctr = 0; ctr < nums.length; ctr++) {
            if(4 == nums[ctr]) {
                indexOf4 = ctr;
                break;
            }
        }
        int[] arr = new int[indexOf4];
        for(int ctr = 0; ctr < indexOf4; ctr++) {
            arr[ctr] = nums[start++];
        }
        return arr;
    }

    public int[] notAlone(int[] nums, int val) {
        for(int ctr = 1; ctr < nums.length - 1; ctr++) {
            if(nums[ctr] == val) {
                if(nums[ctr - 1] > nums[ctr + 1]) {
                    nums[ctr] = nums[ctr - 1];
                } else {
                    nums[ctr] = nums[ctr + 1];
                }
            }
        }
        return nums;
    }
    public boolean sameEnds(int[] nums, int len) {
        int sum = 0, end = nums.length - len;
        for(int ctr=0; ctr<len; ctr++) {
            if(nums[ctr] == nums[end]) {
                sum++;
                end++;
            }
        }
        return len == sum;
    }

    public int centeredAverage(int[] nums) {
        int n = 0, sum = 0;
        Arrays.sort(nums);
        for(int index = 1; index < nums.length -2; index++) {
            sum+=nums[index];
        }
        return sum/nums.length -2;
    }

    public int[] zeroFront(int[] nums) {
        int start  = 0, end = nums.length;
        int[] arr = new int[nums.length];
        for(int n: nums) {
            if(0 == n) {
                arr[start++] = n;
            } else {
                arr[end--] = n;
            }
        }
        return arr;
    }

    public int[] zeroMax(int[] nums) {
        int max = 0;

        for(int ctr = 0; ctr < nums.length; ctr++ ) {
            if(nums[ctr] ==0) {
                max = 0;
                for(int index = ctr; index < nums.length; index++){
                    int candidate = nums[index];
                    if(candidate % 2 == 1 ) {

                        if(nums[index] > max) {
                            max = nums[index];
                        }

                    }
                }

                nums[ctr] = max;
            }
        }
        return nums;
    }



}
