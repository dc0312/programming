package leetcode.linkedlist;

public class LeetCode141LLCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (null != fast && null != fast.next) {
            if (slow == fast) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next = head.next.next;

        System.out.println("Has cycle : " + hasCycle(head));
    }
}
