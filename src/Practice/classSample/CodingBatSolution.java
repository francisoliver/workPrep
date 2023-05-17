package Practice.classSample;

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


}
