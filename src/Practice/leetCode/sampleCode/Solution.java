package Practice.leetCode.sampleCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(nums == null || nums.length < 2 || k == 0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++ ) {
            int n = nums[i];
            if(map.containsKey(n) && Math.abs(map.get(n) - i ) <= k) {
                return true;
            }
            map.put(n, i);
        }
        return false;

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        if (nums.length <= 1 || nums == null) return false;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            Integer floor = set.floor(num + valueDiff);
            Integer ceiling = set.ceiling(num - valueDiff);

            if (floor != null && floor >= num || ceiling != null && ceiling <= num) {
                return true;
            }

            set.add(num);

            if (i >= indexDiff) {
                set.remove(nums[i - indexDiff]);
            }
        }

        return false;

    }

    public int romanToInt(String s) {

        int result = 0, number = 0, prev = 0;
        char n;
        for (int i = s.length() - 1; i >= 0; i--) {

            n = s.charAt(i);
            if(n=='I') number = 1;
            else if(n=='V') number = 5;
            else if(n=='X') number = 10;
            else if(n=='L') number = 50;
            else if(n=='C') number = 100;
            else if(n=='D') number = 500;
            else if(n=='M') number = 1000;

            if (number < prev) {
                result -= number;
            }
            else {
                result += number;
            }
            prev = number;
        }

        return result;

    }

    public String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();

        Arrays.sort(strs);

        char f[]  = strs[0].toCharArray();
        char l[]  = strs[strs.length -1].toCharArray();

        for(int i = 0; i < f.length; i++) {
            if(f[i] != l[i]) {
                break;
            }
            sb.append(f[i]);
        }
        return sb.toString();
    }
}
