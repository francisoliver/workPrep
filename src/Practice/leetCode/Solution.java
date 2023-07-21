package Practice.leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
//        int[] arr = {11,13,15,17};
//        printElements(twoSum(arr, 9));

//        containsDuplicate(arr);
//        productExceptSelf(arr);

        String[] strings = {"eat","tea","tan","ate","nat","bat"};


//        int[] arr = {6,14,15,26,31,36,38,41,42,45};
        int[] arr = {4,5,6,7,8,9};

        System.out.println(arithmeticTriplets(arr , 2));
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

        int left = 0, right = nums.length - 1;
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if ((nums[left] < nums[mid]) && (nums[mid] > nums[right])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return nums[left];

    }

    public int maxArea(int[] height) {

        int maxArea  = 0, start = 0, end = height.length - 1;

        while(start < end) {
            int depth = end - start;
            if(height[start] < height[end]) {
                maxArea = Math.max(maxArea , depth * height[start]);
                start++;
            } else {
                maxArea = Math.max(maxArea, depth * height[end]);
                end--;
            }

        }

        return maxArea;

    }

    public static int getSum(int a, int b) {

        //review
        while (b!=0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = (a & b) << 1;
        }
        return a;

    }

    public static int hammingWeight(int n) {
        int countOne = 0;
        String s = String.valueOf(n);

        for(int i=0; i<s.length(); i ++){
            if(s.charAt(i) =='1') countOne++;
        }
        return countOne;
    }
    public static int hammingWeightYoutube(int n) {
        int countOne = 0;
        while (n!=0) {
            n = n&(n-1);
            countOne++;
        }
        return countOne;
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int aPointer = 0, bPointer = 0, count = 0;
        while(bPointer < s.length()) {

            char c = s.charAt(bPointer);
            if(!set.contains(c)) {
                set.add(c);
                bPointer++;
                count = Math.max(set.size(), count);
            } else {
                set.remove(s.charAt(aPointer));
                aPointer++;
            }

        }
        return count;
    }

    public static int characterReplacement(String s, int k) {

        int aPointer = 0, bPointer = 0;
        char[] arr = s.toCharArray();
        int maxLen = 0, mostFrequent = 0;
        HashMap<Character, Integer> map = new HashMap<>(); //map ABA
        
        while( bPointer < s.length() ) {

            map.put(arr[bPointer], map.getOrDefault(arr[bPointer], 0) + 1);
            mostFrequent = Math.max(mostFrequent, map.get(arr[bPointer]));

            //Shrink the window if we need to replace more than k char
            if((bPointer - aPointer + 1) - mostFrequent > k){
                map.put(arr[aPointer], map.get(arr[aPointer]) - 1);
                aPointer++;
            }
            maxLen = Math.max(maxLen, bPointer - aPointer + 1);
            bPointer++;

        }

        return maxLen;

    }

//    public static int characterReplacement2(String s, int k) {
//        int aPointer = 0, maxCount = 0;
//
//        HashMap<Character, Integer> map = new HashMap<>(); //map ABA
//        for(int bpointer = 0; bpointer < s.length(); bpointer++) {
//            while (bpointer - aPointer - maxCount + 1> k) {
//
//            }
//        }
//
//        return 0;
//
//    }


    public static String minWindow(String s, String t) {
        int start = 0, end = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i =0; i < t.length(); i++) {
            String subs = t.substring(i, i + 1);
            if(s.contains(subs)) {
                if(map.containsKey(s)) {

                    int prevLocation = map.get(subs);

                    if(s.substring(prevLocation + 1).contains(s)) {
                        map.put(subs, i);
                        int index = s.substring(prevLocation + 1).indexOf(subs);
                        start = Math.min(start, index);
                        end = Math.max(end, index);

                    } else {
                        return "";
                    }

                } else {
                    map.put(subs, i);
                    int index = s.indexOf(subs);
                    start = Math.min(start, index);
                    end = Math.max(end, index);
                }
            } else {
                return "";
            }
        }

        return s.substring(start, end + 1);
    }
    public static boolean isAnagram(String s, String t) {
        char[] _s = s.toCharArray();
        char[] _t = t.toCharArray();
        int count = 0;
        Arrays.sort(_s);
        Arrays.sort(_t);

        for(int i =0; i < s.length(); i++) {
            if(_s[i] == _t[i]) {
                count++;
            } else return false;
        }
        return _s.length == count;

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            String key = getFrequncyString(s);
            List<String> stringList;
            if(map.containsKey(key)) {
                stringList = map.getOrDefault(key, new ArrayList<String>());
            } else {
                stringList = new ArrayList<String>();
            }
            stringList.add(s);
            map.put(key, stringList);

        }
        return map.values().stream().toList();

    }

    public static String getFrequncyString(String string) {
        char[] arr = string.toCharArray();
        Arrays.sort(arr);
        String output = "";
        for(char c: arr) {
            output += c;
        }
        return output;
    }

    public int binarySearch(int[] array, int num) {
        int left = 0;
        int right = array.length - 1;

        while(left<=right) {

            int mid = left + (right - left) / 2;
            if(array[mid]==num) {
                return mid;
            } else if (array[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static boolean isValid(String s) {
        if(s.length() % 2 == 1) return false;
        Map<Character, Character> parenthesis = new HashMap<>();
        parenthesis.put(')', '(');
        parenthesis.put(']', '[');
        parenthesis.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(parenthesis.containsKey(c)) {
                if(parenthesis.get(c) == stack.peek() && !stack.empty()) {
                    stack.pop();
                } else return false;
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public static boolean isPalindrome(String s) {

        String normalized = "";
        for(char c : s.toLowerCase().toCharArray()) {
            if(Character.isDigit(c) || Character.isLetter(c)) {
                normalized += c;
            }
        };

        int aPointer = 0, bPointer= normalized.length() - 1;

        while(aPointer<=bPointer) {
            if(normalized.charAt(aPointer++) != normalized.charAt(bPointer--)) {
                return false;
            }
        }

        return true;

    }

    public static String longestPalindrome(String s) {

        int len = s.length() , aPointer = 0,  bPointer = len;
        int maxLength = 1, start = 0;



        for(int i = 0; i < len; i++) {
//            if(i % 2 ==0 && i != len) {
//                aPointer = i;
//            } else {
//                aPointer = i - 1;
//            }
//            bPointer = i + 1;
            aPointer = i - 1;
            bPointer = i + 1;
            while(aPointer >= 0 && bPointer < len & s.charAt(aPointer) ==s.charAt(bPointer)) {
                if (bPointer - aPointer + 1 > maxLength) {
                    start = aPointer;
                    maxLength = bPointer - aPointer + 1;
                }
                aPointer--;
                bPointer++;
               /* String palindrome = "";
                if(aPointer>0) {
                    palindrome = s.substring(aPointer, bPointer + 1);
                } else {
                    palindrome = s.substring(aPointer, bPointer + 1);
                }
                System.out.println(palindrome);
                if(isPalindrome(palindrome)) {
                    if(palindrome.length() > longestPalindrome.length()) {
                        longestPalindrome = palindrome;
                    }
                }

                aPointer--;
                bPointer++;*/
            }

        }

        return s.substring(start, start + maxLength);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m; i < m+ n; i ++) {
            nums1[i] = nums2[i - m];
        }
    }

    public int removeDuplicates(int[] nums) {

        Set<Integer> sets = new HashSet<>();
        for (int n: nums) {
            sets.add(n);
        }

        return sets.size();

    }

    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }

    public int largestAltitude(int[] gain) {
        return Arrays.stream(gain).max().getAsInt();
    }

    public int removeElement(int[] nums, int val) {
        int size = 0;
        for(int n: nums) {
            if(n!=val) {
                nums[size++] = n;
            }
        }
        return size;
    }

    public static int majorityElement(int[] nums) {
        if(nums.length == 1 ) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0, num= 0;
        int k = nums.length / 2;
        for(int n = 0; n < k; n++) {
            int i = nums[n];
            map.put(i, map.getOrDefault(i, 0) + 1);

            int count = map.get(i);
            if(count > maxFreq) {
                maxFreq = count;
                num = i;
            }

        }

        return num;

    }

    public static boolean buddyStrings(String s, String goal) {

      if(s.length()!=goal.length()) return false;
      int count = 0;
      for (int i =0; i< s.length(); i++) {
          if(s.charAt(i) == goal.charAt(i)) {
              count++;
          }
      }
      return count - 2 == s.length();

    }

    public static boolean canPlaceFlowers(int[] f, int n) {

        if (n == 0) return true;

        if (f.length == 1) {
            return f[0] == 0;
        }
        int len = f.length;
        for (int i = 0; i < len; i++) {

            if (1 == f[i]) continue;

            if (i == len - 1 && f[i - 1] == 0) {
                f[i] = 1;
                n--;
            } else if (i != 0 && i != len - 1 && f[i + 1] == 0 && f[i - 1] == 0) {
                f[i] = 1;
                n--;
            } else if (i == 0 && f[i + 1] == 0) {
                f[i] = 1;
                n--;
            }

            if (0 == n) {
                return true;
            }

        }
        return n == 0;

    }


    public void moveZeroes(int[] nums) {

        int left = 0, right = 1;
        while (right < nums.length) {
            if(nums[left]!= 0) {
                left++;
                right++;
            } else if (nums[right] ==0) {
                right++;
            } else {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        int len = nums.length;

        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < len; i++) {
            set.add(nums[i]);

            if(set.contains(nums[i] - diff )&& set.contains(nums[i] - (2 * diff))) {
                count++;
            }
        }

        return count;
    }

    public String reversePrefix(String word, char ch) {

        String s = "";
        s += ch + "";
        int index = word.indexOf(s);
        if (index < 0) return  word;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(word.substring(0, index + 1));
        stringBuilder.reverse();
        stringBuilder.append(word.substring(index));
        return stringBuilder.toString();

    }

    public String reverseWords(String s) {
        String[] str = s.split(" ");

        String output = "";

        for(String word: str) {

            StringBuilder sb = new StringBuilder(word);
            if(output.length() > 0) {
                output+= " ";
            }
            output+= sb.reverse().toString();

        }

        return output;

    }

    public String truncateSentence(String s, int k) {
        String[] str = s.split(" ");
        String output = "";
        int index = 0;
        while(k > 0) {
            k--;
            if(output.length()>0) {
                output += " ";
            }
            output += str[index++];

        }

        return output;

    }

}
