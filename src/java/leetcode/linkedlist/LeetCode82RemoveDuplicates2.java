package leetcode.linkedlist;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 */
public class LeetCode82RemoveDuplicates2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(5);
        display(head);
        head = removeDuplicates(head);
        display(head);
    }

    private static ListNode removeDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode current = head;
        while (null != current) {
            ListNode next = current.next;
            if (null != next && next.val == current.val) {
                while(null != next && next.val == current.val){
                    current = next;
                    next = current.next;
                }
                prev.next = next;
            }else{
                prev = current;
            }
            current = next;
        }
        return fakeHead.next;
    }

    public static void display(ListNode head) {
        ListNode temp = head;
        while (null != temp) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }
}
