package Practice.leetCode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        int[] arr = {11,13,15,17};
        int[] arr = {2 , 1};
//        printElements(twoSum(arr, 9));

//        containsDuplicate(arr);
//        productExceptSelf(arr);
        System.out.println(findMin(arr));

    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                return new int[] {i, map.get(diff)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no match");
    }

    public int maxProfit(int[] prices) {
        int initial = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            if(initial>prices[i]) {
                initial = prices[i];
            } else if(prices[i] - initial > max){
                max = prices[i]- initial;
            }
        }
        return max;
    }



    public static <T> void printElements(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int n: nums) {
            if(!set.add(n)) {
                return false;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);

        for(int i = 1; i< nums.length - 1; i++) {
            if(nums[i] == nums[i -1]) {
                return false;
            }

        }
        return false;
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        right[0] = 1;
        right[1] = nums[0];
        left[len - 1] = 1;
        left[len - 2] = nums[len - 1];
        for(int i = 2; i < len ; i++) {
            right[i] = nums[i - 1] * right[i - 1];
        }

        for(int i = len - 3; i >= 0 ; i--) {
            left[i] = nums[i + 1] *  left[ i + 1];
        }

        for(int i = 0; i < len; i++) {
            left[i] = left[i] * right[i];
        }

        return left;
    }

    //kadane
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currentSum = maxSum;
        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i] + currentSum, nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;

    }

    public int maxProduct(int[] nums) {
        if(nums.length < 2) return nums[0];
        int max = nums[0];
        int min = max;
        int result = max;
        for(int i = 1; i < nums.length; i++) {

            int temp = Math.max(nums[i] * max , Math.max(nums[i] * min, nums[i]));
            min = Math.min(nums[i] * max , Math.min(nums[i] * min, nums[i]));

            max = temp;
            result = Math.max(result, max);

        }
        return result;
    }

    public static int findMin(int[] nums) {

        int pivot = nums[0];
//11,13,15,17
        for(int i = 1; i < nums.length; i++) {
            if(i + 1 == nums.length) return nums[0];
            if(nums[i] < pivot) {
                return nums[i];
            }
            pivot = nums[i];
        }

        return pivot;

    }


}
