package leetcode.linkedlist;


public class LeetCode876MiddleElement {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        LeetCode876MiddleElement leetCode876MiddleElement = new LeetCode876MiddleElement();
        System.out.println("Return element : " + leetCode876MiddleElement.middleNode(head).val);
    }

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
