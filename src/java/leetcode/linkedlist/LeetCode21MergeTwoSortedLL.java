package leetcode.linkedlist;

public class LeetCode21MergeTwoSortedLL {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(8);
        l2.next.next.next = new ListNode(10);

        ListNode newHead = mergeTwoLists(l1, l2);
        display(newHead);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                current.next = new ListNode(l1.val);
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                current = current.next;
                l2 = l2.next;
            }
        }

        while(null != l1){
            current.next = new ListNode(l1.val);
            current = current.next;
            l1 = l1.next;
        }
        while(null != l2){
            current.next = new ListNode(l2.val);
            current = current.next;
            l2 = l2.next;
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
