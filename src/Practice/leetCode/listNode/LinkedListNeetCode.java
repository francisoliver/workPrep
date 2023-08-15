package Practice.leetCode.listNode;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LinkedListNeetCode {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while(head!= null) {
            ListNode node = head.next;
            head.next = prev;
            prev = head;
            head = node;
        }

        return prev;
    }

        public void reorderList(ListNode head) {

        //Find middle of list using a slow and fast pointer approach
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the second half of the list using a tmp variable
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        //Re-assign the pointers to match the pattern
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final ListNode root = new ListNode();
        ListNode temp = root;

        while(list1!= null || list2!=null) {
            //populate
            if(list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 != null ? list1 : list2;
        return root.next;

    }

    public ListNode removeNthFromEndRev(ListNode head, int n) {

        ListNode node = head;
        while(n > 0) {
            head = head.next;
            n --;
        }

        ListNode temp = head.next.next;
        head.next = temp;

        return node;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode node = new ListNode(0, head);
        node.next = head;
        ListNode first = node, second = node;

        while(n > 0) {
            second = second.next;
            n --;
        }

        while(second!=null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;
        return node.next;

    }

    public Node copyRandomList(Node head) {

        HashMap<Node, Node> map = new HashMap<>();
        Node node = head;

        while(node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while(node != null) {

            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode tail = head;
        int c = 0;
        while (l1 != null || l2 != null || c != 0) {

            int d1 = (l1 != null) ? l1.val : 0;
            int d2 = (l2 != null) ? l2.val : 0;
            int n = d1 + d2 + c; //get the sum of two listNode + carry

            ListNode sum;
            if (n > 9) {
                sum = new ListNode(n % 10);
                c = 1;
            } else {
                sum = new ListNode(n % 10);
                c = 0;
            }

            tail.next = sum;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;

        }

        return head.next;

    }

    public boolean hasCycle(ListNode head) {

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow ) return true;
        }
        return false;

    }

    public int findDuplicate(int[] nums) {

        int t = nums[0], h = nums[0];

        do {
            t = nums[t];
            h = nums[nums[h]];
        } while (t!=h);

        t = nums[0];
        while(t!=h) {
            t = nums[t];
            h = nums[h];
        }

        return t;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return dummy.next;
    }


}
