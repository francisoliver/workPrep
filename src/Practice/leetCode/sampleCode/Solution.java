package Practice.leetCode.sampleCode;

import java.util.HashMap;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(nums == null || nums.length < 2 || k == 0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++ ) {
            if(map.containsKey(nums[i])) {
                if(Math.abs(map.get(nums[i]) - i ) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;

    }
}
