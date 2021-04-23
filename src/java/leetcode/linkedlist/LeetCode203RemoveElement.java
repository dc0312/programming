package leetcode.linkedlist;

public class LeetCode203RemoveElement {

    public static ListNode removeElements(ListNode head, int val) {
//        while(null != head && head.val == val){
//            head = head.next;
//        }
//        if(null == head){
//            return head;
//        }
        ListNode dummy_head = new ListNode(-1);
        dummy_head.next = head;

        ListNode temp = dummy_head;
        while (null != temp.next) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }

        }
        return dummy_head.next;
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
        head = removeElements(head, 1);
        display(head);
    }
}
