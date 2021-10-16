package leetcode.linkedlist;

public class LeetCode142LLCycle2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next = head.next.next;
        System.out.println(null == cycle(head) ? -1 : cycle(head).val);
    }

    private static ListNode cycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            return null;
        } else {
            slow = head;
            while (slow.val != fast.val) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}
