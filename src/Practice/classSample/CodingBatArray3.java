package Practice.classSample;

import java.util.*;

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

    public int countClumps(int[] nums) {
        int clumps = 0;
        boolean isPrevClump = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (!isPrevClump) {
                    clumps++;
                    isPrevClump = true;
                }
            } else {
                isPrevClump = false;
            }
        }

        return clumps;
    }

    public int[] fix45(int[] nums) {
        int index3 = 0;
        int index4 = 0;

        while (index3 < nums.length && nums[index3] != 4) {
            index3++;
        }

        while (index4 < nums.length && (nums[index4] != 5 || (index4 > 0 && nums[index4 - 1] == 4))) {
            index4++;
        }

        while (index3 < nums.length && index4 < nums.length) {
            if (nums[index3] == 4) {
                int temp = nums[index3 + 1];
                nums[index3 + 1] = nums[index4];
                nums[index4] = temp;

                while (index4 < nums.length && (nums[index4] != 5 || (index4 > 0 && nums[index4 - 1] == 4))) {
                    index4++;
                }
            }
            index3++;
        }

        return nums;
    }

    public String[] wordsWithout(String[] words, String target) {
        int count = 0;
        for (String word : words) {
            if (!word.equals(target)) {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;
        for (String word : words) {
            if (!word.equals(target)) {
                result[index++] = word;
                if (index == count) {
                    break; // Break the loop if all non-target words are added to the result
                }
            }
        }

        return result;
    }

    public String[] wordsFront(String[] words, int n) {
        String[] result = new String[n];
        for(int i = 0; i < n; i++) {
            result[i] = words[i];
        }
        return result;
    }

    public boolean hasOne(int n) {
        while (n > 9) {
            int tens = n / 10, ones = n % 10;
            if (tens == 10 || ones == 1) return true;
            n = tens;
        }
        return n == 1;
    }

    public List wordsWithoutList(String[] words, int len) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (word.length() != len) {
                list.add(word);
            }
        }
        return list;
    }

    public int scoreUp(String[] key, String[] answers) {
        int score = 0;
        for(int i =0; i< key.length; i++) {
            if(key[i] ==answers[i]) {
                score+=4;
            } else if (answers[i] =="?") {
                continue;
            } else if (key[i] !=answers[i]) {
                score-=1;
            }
        }
        return score;
    }

    public int wordsCount(String[] words, int len) {
        int count = 0;
        for(String word: words) {
            if(word.length() == len) count++;
        }
        return count;
    }

    public boolean dividesSelf(int n) {

        while (n > 9) {
            int tens = n / 10, ones = n % 10;
            if (tens == 10 || ones == 0) return false;
            n = tens;
        }
        return n != 0 ;
    }

    public int[] copyEvens(int[] nums, int count) {
        int[] arr = new int[count];
        int index = 0;

        for (int i = 0; i < count; i++) {
            while (index < nums.length) {
                if (nums[index] % 2 == 0) {
                    arr[i] = nums[index];
                    break;
                }
                index++;
            }
            index++;
        }

        return arr;
    }

    public int sumHeights(int[] heights, int start, int end) {
        int diff = 0, prev = heights[start];
        for(int i = start; i <= end; i++) {
            diff += Math.abs((heights[i] - prev));
            prev = heights[i];
        }
        return diff;
    }

    public String[] mergeTwo(String[] a, String[] b, int n) {
        String[] result = new String[n];
        int i = 0, j = 0;

        for (int index = 0; index < n; index++) {
            if (index > 0) {
                if (i < a.length && a[i].equals(result[index - 1])) {
                    i++;
                }
                if (j < b.length && b[j].equals(result[index - 1])) {
                    j++;
                }
            }
            if (i < a.length && (j >= b.length || a[i].compareTo(b[j]) <= 0)) {
                result[index] = a[i++];
            } else {
                result[index] = b[j++];
            }
        }

        return result;
    }




}
