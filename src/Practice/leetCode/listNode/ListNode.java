package Practice.leetCode.listNode;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() throws NullPointerException {
        try {
            return "\n this is " + val + " my next is === " + next.val;
        } catch (NullPointerException e) {
            return "\n this is " + val + " my next is === NULL" ;
        }
    }
}