package leetcode.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 */
public class LeetCode24SwapNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        display(swapNodes(head));
    }

    private static ListNode swapNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode runner = dummy;
        while (null != runner.next && null != runner.next.next) {
            ListNode aNode = runner.next;
            ListNode bNode = runner.next.next;

            runner.next = aNode.next;
            aNode.next = bNode.next;
            bNode.next = aNode;

            runner = runner.next.next;

        }
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
