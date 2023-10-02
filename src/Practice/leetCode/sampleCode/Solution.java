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
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        solution.uniqueMorseRepresentations();
//        solution.decodeMessage(key, message);
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


}
