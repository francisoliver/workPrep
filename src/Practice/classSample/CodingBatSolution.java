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


}
