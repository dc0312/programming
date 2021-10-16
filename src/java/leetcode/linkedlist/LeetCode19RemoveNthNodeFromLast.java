package leetcode.linkedlist;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */
public class LeetCode19RemoveNthNodeFromLast {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        int k = 2;
        display(head);
        head = removeElement(head, k);
        display(head);
    }

    private static ListNode removeElement(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;

        for (int i = 1; i <= k + 1; i++) {
            fast = fast.next;
        }

        while (null != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void display(ListNode head) {
        ListNode current = head;
        while (null != current) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println();
    }
}
