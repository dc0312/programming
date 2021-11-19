package leetcode.linkedlist;

public class LeetCode2AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode newNode = addTwoNumbers(l1, l2);
        display(newNode);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int c = 0;

        ListNode dummy = new ListNode(-1);
        ListNode newNode = dummy;

        while (l1 != null || l2 != null || c != 0) {

            int sum = 0;

            if (null != l1) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (null != l2) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += c;

            int q = sum % 10;
            c = sum / 10;

            newNode.next = new ListNode(q);
            newNode = newNode.next;
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
