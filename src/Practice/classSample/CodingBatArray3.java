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

    public int maxMirror2(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int n : nums) sb.append(n);
        String s = sb.toString();
        String rev = sb.reverse().toString();
        int sum = 0;
        for(int start =0; start < s.length(); start++) {
            int counter = 0;
            for(int end  = start; end < s.length(); end++) {
                String subs = rev.substring(start, end + 1);
                if(s.contains(subs)) {
                    System.out.println("this is the substring = " + subs);
                    System.out.println("index of  = " + s.indexOf(subs));
                    counter++;
                    continue;
                }
                break;
            }
            if(counter > sum) {
                sum = counter;
                System.out.println("new sum encountered! please see above! sum was " +sum);
            }
            counter = 0;
        }
        return sum;

    }

    public int[] seriesUp(int n) {
        int limit = n * (n + 1) / 2, counter = 0;
        int[] arr = new int[limit];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[counter++] = j;
            }
        }
        return arr;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        int counter = 0, tmp = 0;
        boolean found = false;

        for (int i = 0; i < inner.length; i++) {

            while (counter < outer.length && !found) {
                if (inner[i] == outer[counter]) {
                    found = true;
                    tmp++;
                    continue;
                }
                counter++;
            }
            found = false;

        }
        return tmp == inner.length;

    }





}
