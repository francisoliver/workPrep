package Practice.classSample;

import java.util.*;
import java.util.stream.Collectors;

public class CodingBatArray3 {
    public int maxSpan(int[] nums) {
        int[] unique = Arrays.stream(nums).distinct().toArray();
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        int diff = 0, max = 0;
        for (int n : unique) {
            int low = list.indexOf(n), high = list.lastIndexOf(n);
            diff = Math.abs(low - high);
            if (diff > max) {
                max = diff + 1;
            }
        }
        return max;
    }

    public int[] fix34(int[] nums) {
        int index3 = 0;
        int index4 = 0;

        while (index3 < nums.length && nums[index3] != 3) {
            index3++;
        }

        while (index4 < nums.length && (nums[index4] != 4 || (index4 > 0 && nums[index4 - 1] == 3))) {
            index4++;
        }

        while (index3 < nums.length && index4 < nums.length) {
            if (nums[index3] == 3) {
                int temp = nums[index3 + 1];
                nums[index3 + 1] = nums[index4];
                nums[index4] = temp;

                while (index4 < nums.length && (nums[index4] != 4 || (index4 > 0 && nums[index4 - 1] == 3))) {
                    index4++;
                }
            }
            index3++;
        }

        return nums;
    }

    public boolean canBalance(int[] nums) {
        int leftSum = 0, rightSum = Arrays.stream(nums).sum();
        for (int n : nums) {
            leftSum += n;
            rightSum -= n;
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    public int maxMirror(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int n : nums) sb.append(n);
        String s = sb.toString();
        String rev = sb.reverse().toString();
        for(int start =0; start < s.length(); start++) {
            for(int end  = start; end < s.length(); end++) {
                String subs = s.substring(start, end + 1);
                System.out.println(subs);
            }

        }
        return 1;

    }



}
