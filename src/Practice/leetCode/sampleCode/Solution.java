package Practice.leetCode.sampleCode;

import Practice.leetCode.listNode.ListNode;
import Practice.leetCode.trees.TreeNode;

import java.util.*;

public class Solution {

    static String[] mors = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] array = {1,2,3,4,5,6,7, 1 , 1 ,3, 5, 7};
//        int[] array = {8,1,2,2,3};
//        solution.smallerNumbersThanCurrent(array);
        /*
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";

        //[["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
        List<List<String >> city = new ArrayList<>();
        String newYork = "new york";
        String lima = "lima";
        String london = "london";
        String sao = "sao paulo";

        List<String> a = new ArrayList<>();
        a.add(london);
        a.add(newYork);
        city.add(a);
        //
        List<String> b = new ArrayList<>();
        b.add(newYork);
        b.add(lima);
        city.add(b);
        //
        List<String> c = new ArrayList<>();
        c.add(lima);
        c.add(sao);
        city.add(c);


//        solution.destCity(city);
//        solution.areOccurrencesEqual("aaabb");
//        solution.uniqueMorseRepresentations();
//        solution.decodeMessage(key, message);

//        solution.sortString("aaaabbbbcccc");
//        solution.numberOfPairs(new int[]{1,3,2,1,3,2,2});
*/
        int[] arr = new int[]{1,5,2,4,1};
        solution.minOperations(arr);

    }
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

    public int removeDuplicates(int[] nums) {
        int index = 1;
        for(int i =0; i < nums.length - 1; i++) {
            if(nums[i]!= nums[i+1]) {
                nums[index++] = nums[i+1];
            }
        }
        return index;
    }

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, c = 0;

        while(i>=0||j>=0) {
            int sum = c;
            if(i>=0) sum+=a.charAt(i) - '0';
            if(j>=0) sum+=b.charAt(j) - '0';
            sb.append(sum % 2) ;
            c = sum / 2;
            i--;j--;
        }

        if(c!=0) sb.append(c);
        return sb.reverse().toString();

    }
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && dummy.next.next != null) {
            if (current.next.next.val == current.next.val) {
                int similar = current.next.val;
                while(current.next!=null && current.next.val==similar){
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }

        return dummy.next;

    }

    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if(node==null) return result;
        Stack<TreeNode> treeNodeStack = new Stack<>();

        while (node!= null || !treeNodeStack.isEmpty()) {
            while(node!=null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            node = treeNodeStack.pop();
            result.add(node.val);
            node = node.right;
        }

        return result;
    }

    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversalDFS(TreeNode root) {
        traverseInorder(root);
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        traversePostOrder(root);
        return res;
    }

    private void traverseInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseInorder(root.left);
        res.add(root.val);
        traverseInorder(root.right);
    }
    private void traversePostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        res.add(root.val);
    }
    public int numJewelsInStones(String jewels, String stones) {

        int output = 0;
        for(char c: stones.toCharArray()) {
            if(jewels.contains(String.valueOf(c))) output++;
        }
        return output;

    }

    public int[] smallerNumbersThanCurrent(int[] nums) {

        TreeMap<Integer, Integer> set = new TreeMap<>();
        for(int n: nums) {

            if(set.containsKey(n)) {
                set.put(n, set.get(n) + 1);
            } else {
                set.put(n, 1);
            }

        }

        int size = 0;

        for(int n: set.keySet()) {
            int temp = set.get(n);
            set.put(n, size);
            size = size + temp;
        }
        for(int i=0; i<nums.length; i++){
            nums[i] = set.get(nums[i]);
        }

        return nums;
    }

    public String decodeMessage(String key, String message) {

        HashMap<Character, Character> map = new HashMap<>();
        char a = 'a';
        key = key.replaceAll(" ", "");

        for(Character c: key.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, a++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c: message.toCharArray()) {
            if(c == ' ') {
                sb.append(" ");
            } else {
                sb.append(map.get(c));
            }

        }

        return sb.toString();
    }

    public boolean checkIfPangram(String sentence) {

        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<sentence.length(); i++) {
            char c = sentence.charAt(i);
            if(c>='a' && c <='z') {//can use Character.isAlphabetic(c)
                set.add(c);
            }
        }

        return set.size()>=26;

    }

    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(mors[c - 97]);
            }
            System.out.println(sb.toString());
            set.add(sb.toString());
        }
        return set.size();
    }

    public int countConsistentStrings(String allowed, String[] words) {

        int counter = 0;
        for(String word: words) {
            boolean flag = true;
            for(char c: allowed.toCharArray()) {
                if(-1 == word.indexOf(c)) {
                    flag = false;
                    break;
                }
            }
            if(flag) counter++;
        }
        return counter;

    }

    public String[] sortPeople(String[] names, int[] heights) {

        HashMap<Integer, String> map = new HashMap<>();
        for(int i=0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        int index = 0;
        String[] result = new String[names.length];

        for(int i= names.length -1; i >= 0; i--) {
            result[index++] = map.get(heights[i]);
        }

        return result;
    }

    public int maximumNumberOfStringPairs(String[] words) {
        int ctr = 0;

        for(int i = 0; i < words.length - 1; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            String rev = sb.reverse().toString();
            for(int j = i+ 1; j < words.length; j++) {
                if(rev.equals(words[j])) ctr++;
            }
        }

        return ctr;

    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>(getDifference(nums2, nums1)));
        result.add(new ArrayList<Integer>(getDifference(nums1, nums2)));
        return result;

    }

    HashSet<Integer> getDifference(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        for(int n: nums1) {
            set.add(n);
        }

        HashSet<Integer> result = new HashSet<>();

        for(int n: nums2) {
            if(!set.contains(n)) result.add(n);
        }
        return result;

    }

    public String destCity(List<List<String>> paths) {

        List<String> city = new ArrayList<>();
        List<String> destination = new ArrayList<>();

        for(List<String> path: paths) {
            city.add(path.get(0));
            destination.add(path.get(1));
        }

        for(String s : city) {
            destination.remove(s);

        }
        return destination.get(0);

    }

    public boolean areOccurrencesEqual(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c ,0) + 1);
        }

        int size = 0;
        for(int n: map.values()) {
            if(size==0) {
                size = n;
            } else if(n==size) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public int sumOfUnique(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                continue;
            }
            sum+=entry.getKey();
        }
        return sum;

    }

    public String sortString(String s) {

        TreeMap<Character, Integer> set = new TreeMap();

        for(char c: s.toCharArray()) {
            set.put(c, set.getOrDefault(c, 0) + 1);
        }

        boolean flag = true;
        String output = "";
        while (output.length() < s.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for(char c: set.keySet()) {
                if(set.get(c)!=0) {
                    set.put(c, set.get(c) - 1);
                    stringBuilder.append(c);
                }
            }
            if(flag) {
                output += stringBuilder.toString();
                flag = false;
            } else {
                output += stringBuilder.reverse().toString();
                flag = true;
            }

        }

        return output;
    }

    public String sortString2(String s) {

        int[] arr = new int[26];

        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i)-'a';
            arr[index] = arr[index]+1;
        }

        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()){

            for(int i=0; i<26; i++){
                if (arr[i]>0){
                    char ch = (char)('a'+i);
                    sb.append(ch);
                    arr[i]--;
                }
            }

            for(int i=25; i>=0; i--){
                if (arr[i]>0){
                    char ch = (char)('a'+i);
                    sb.append(ch);
                    arr[i]--;
                }
            }

        }

        return sb.toString();
    }
    public int[] numberOfPairs(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        int frequencySum = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            frequencySum += entry.getValue() / 2;
        }

        return new int[] { frequencySum, nums.length - frequencySum * 2 };
    }

    public int[] buildArray(int[] nums) {


        int[] arr = new int[nums.length];
        int index = 0;
        for(int n: nums) {
            arr[index++] = nums[n];
        }

        return arr;
    }

    public int[] getConcatenation(int[] nums) {

        int len = nums.length * 2;
        int[] arr = new int[len];

        for(int i = 0; i < len; i++) {
            int index = i >= nums.length ? i - nums.length  : i;
            arr[i] = nums[index];
        }

        return arr;
    }

    public String interpret(String command) {

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < command.length()) {

            if(command.charAt(index) == 'G') {
                sb.append("G");
                index++;
            } else if(command.charAt(index + 1) == 'a') {
                sb.append("al");
                index+= 4;
            } else {
                sb.append("o");
                index+= 2;
            }
        }

        return sb.toString();

    }
    
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int count = 0, choice;

        for(List<String> item: items) {
            if(ruleKey.equals("type")) {
                choice = 0;
            } else if(ruleKey.equals("color")) {
                choice = 1;
            } else {
                choice = 2;
            }
            if(item.get(choice).equals(ruleValue))
                count++;
        }

        return count;

    }

    public int minOperations(int[] nums) {

        int operations = 0;
        for(int i = 0; i< nums.length - 1; i++) {
            if(nums[i]>=nums[i+1]) {
                int temp = nums[i] - nums[i+1] + 1;
                nums[i+1] = temp + nums[i+1];
                operations+=temp;
            }
        }
        return operations;

    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> output = new ArrayList<>();
        for(int i =0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            List<Integer> list = map.getOrDefault(size, new ArrayList<>());
            list.add(i);
            map.put(size, list);
            if(size == map.get(size).size()) {
                output.add(new ArrayList<>(map.get(size)));
                map.get(size).clear();
            }
        }

        return output;
    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode res = dummy;

        while(dummy.next!=null ) {
            if(dummy.next.val==val) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return res.next;

    }

}