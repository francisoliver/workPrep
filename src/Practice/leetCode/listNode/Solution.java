package Practice.leetCode.listNode;

import java.util.List;

public class Solution {
    public static void main(String[] args) {

        ListNode fifth = new ListNode(5);
        ListNode forth = new ListNode(4,fifth);
        ListNode third = new ListNode(3, forth);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);

        ListNode[] nodes = {first, second, third,forth, fifth};

        for(ListNode n: nodes) {
            System.out.println(n);
        }

        LinkedListNeetCode code = new LinkedListNeetCode();
        code.reverseList(first);
        System.out.println("Performing reverse order!");
        for(ListNode n: nodes) {
            System.out.println(n);
        }

        System.out.println("Hello world!");
    }
}
