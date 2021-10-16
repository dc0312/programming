package leetcode.linkedlist;

public class LeetCode86PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        int x = 3;

        partition(head, x);
    }

    private static void partition(ListNode head, int x) {
        ListNode beforeNode = new ListNode(-1);
        ListNode afterNode = new ListNode(-1);

        while (null != head) {
            if (head.val < x) {
                beforeNode.next = new ListNode(head.val);
                beforeNode = beforeNode.next;
            } else {
                afterNode.next = new ListNode(head.val);
                afterNode = afterNode.next;
            }

        }
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
