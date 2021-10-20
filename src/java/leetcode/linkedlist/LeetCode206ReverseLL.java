package leetcode.linkedlist;

import java.util.List;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class LeetCode206ReverseLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        LeetCode206ReverseLL leetCode206ReverseLL = new LeetCode206ReverseLL();
        leetCode206ReverseLL.display(head);
        ListNode newHead = leetCode206ReverseLL.reverseListNew(head);
        leetCode206ReverseLL.display(newHead);
        ListNode newHeadNew = leetCode206ReverseLL.reverseList(newHead);
        leetCode206ReverseLL.display(newHeadNew);
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (null != head) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseListNew(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (null != current) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public void display(ListNode head) {
        ListNode temp = head;
        while (null != temp) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }
}
