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

        for(int val = n; val != 0; val /= 10) {
            int digit = val % 10;
            if(digit == 0 || n % digit != 0)
                return false;
        }

        return true;
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

    public int sumHeights2(int[] heights, int start, int end) {
        int diff = 0, prev = heights[start], multiplier;
        for(int i = start; i <= end; i++) {
            int step = heights[i];
            if(step > prev) {
                multiplier = 2;
            } else {
                multiplier = 1;
            }
            diff += Math.abs((step - prev)) * multiplier;
            prev = heights[i];
        }
        return diff;
    }

    public int userCompare(String aName, int aId, String bName, int bId) {
        int nameComparison = aName.compareTo(bName);

        if (nameComparison != 0) {
            return Integer.compare(nameComparison, 0);
        } else {
            return Integer.compare(aId, bId);
        }
    }

    public boolean scores100(int[] scores) {
        for(int i=0; i< scores.length - 1; i++) {
            if(scores[i] == 100 && scores[i+ 1] ==100) return true;
        }
        return false;
    }

    public int commonTwo(String[] a, String[] b) {
        HashSet<String> setA = new HashSet<>(Arrays.asList(a));
        HashSet<String> setB = new HashSet<>(Arrays.asList(b));

        setA.retainAll(setB);
        return setA.size();
    }
    public int bigHeights(int[] heights, int start, int end) {

        int diff = 0, prev = heights[start], count = 0;
        for(int i = start; i <= end; i++) {
            diff = Math.abs((heights[i] - prev));
            if(diff>4) count++;
            prev = heights[i];
        }
        return count;
    }


    public boolean scoresClump(int[] scores) {
        for(int i =0; i < scores.length - 2; i++) {
            if(Math.abs(scores[i] - scores[i+ 2] ) <= 2) {
                return true;
            }
        }
        return false;
    }
    public int[] copyEndy(int[] nums, int count) {

        int[] result = new int[count];
        int index = 0;

        for (int n :nums) {
            if (isEndy(n)) {
                if(index == count) {
                    break;
                }
                result[index++] = n;
            }
        }
        return result;

    }
    boolean isEndy(int n) {
        return n >= 0 && n <= 10 || n >= 90 && n <= 100;
    }

    public int scoresSpecial(int[] a, int[] b) {
        return maxIntInArray(a)+ maxIntInArray(b);
    }

    int maxIntInArray(int[] nums ) {
        int max = 0;
        for(int n: nums) {
            if(n % 10 == 0) {
                if(n > max) {
                    max = n;
                }
            }
        }
        return max;
    }

    public int factorial(int n) {
        return n * (n - 1);
    }

    public int countHi(String str) {

        if (str.length() < 2){
            return 0;
        }

        if (str.substring(0,2).equals("hi")){
            return 1 + countHi(str.substring(1));
        }

        else {
            return countHi(str.substring(1));
        }

    }

    public String changeXY(String str) {
        if (str.equals("")) {
            return str;
        }
        if (str.charAt(0) == 'x'){
            return "y" + changeXY(str.substring(1));
        }
        return str.charAt(0) + changeXY(str.substring(1));
    }

    public List<String> copies3(List<String> strings) {
        return strings.stream().map(s ->s + s +s).collect(Collectors.toList());   // .replaceAll(s -> s + s + s);
    }
    public List<Integer> square(List<Integer> nums) {
        return nums.stream().map(integer -> integer * integer).collect(Collectors.toList());
    }

    public List<String> noX(List<String> strings) {
        return strings.stream().map(s-> s.replace("x", "")).collect(Collectors.toList());
    }

    public List<Integer> math1(List<Integer> nums) {
        return nums.stream().map(i -> (i + 1) * 10).collect(Collectors.toList());
    }

    public List<String> moreY(List<String> strings) {
        return strings.stream().map(s-> "y" + s + "y").collect(Collectors.toList());
    }

    public List<Integer> noNeg(List<Integer> nums) {
        return nums.stream().filter(i -> i >= 0).collect(Collectors.toList());
    }

    public List<Integer> square56(List<Integer> nums) {
        return nums.stream().map(i-> (i * i) + 10 ).filter(i-> i % 10!= 6 && i % 10!= 5).collect(Collectors.toList());
    }

    public List<Integer> noTeen(List<Integer> nums) {
        return nums.stream().filter(i-> i < 13 || i > 19 ).collect(Collectors.toList());
    }

    public List<String> noZ(List<String> strings) {
        return strings.stream().filter(s-> !s.contains("z")).collect(Collectors.toList());
    }

    public List<String> noYY(List<String> strings) {
        return strings.stream().
                map(s->s+"y").
                filter(s-> !s.contains("yy")).
                collect(Collectors.toList());
    }

}
