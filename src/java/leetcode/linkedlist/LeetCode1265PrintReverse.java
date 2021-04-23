package leetcode.linkedlist;

public class LeetCode1265PrintReverse {

    public static void printReverse(ListNode head) {
        if (null == head) {
            return;
        }
        printReverse(head.next);
        System.out.print(head.val + "->");
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
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        display(head);
        printReverse(head);
    }
}
