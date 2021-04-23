package leetcode.linkedlist;

public class LeetCode1721SwapNodes {

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode temp = null;
        ListNode fast = head;

        while (k > 0) {
            temp = fast;
            fast = fast.next;
            --k;
        }

        while (null != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        int newTemp = temp.val;
        temp.val = slow.val;
        slow.val = newTemp;

        return head;

    }

    public static void display(ListNode head) {
        ListNode temp = head;
        while (null != temp) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        display(head);
        swapNodes(head, 2);
        display(head);
    }
}
