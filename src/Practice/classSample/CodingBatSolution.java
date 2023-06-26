package Practice.classSample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodingBatSolution {
    public boolean array123(int[] nums) {
        int len = nums.length;
        if(len < 3) return false;
        boolean found = false;
        for(int n = 0; n < len - 2; n++) {
            if(1 == nums[n] && 2 == nums[n + 1] && 3 == nums[n+2]) {
                found = true;
            }
        }
        return found;
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
        StringBuilder sb = new StringBuilder();
        int match = 0, len = word.length();

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
        String output;
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
                } else {
                }
            } else {
                currentValue = big * 5;
                int diff = goal - currentValue;
                if(diff <= small) {
                    currentValue += diff;
                }
            }
        System.out.println(currentValue);
        return currentValue == goal;
    }



}
