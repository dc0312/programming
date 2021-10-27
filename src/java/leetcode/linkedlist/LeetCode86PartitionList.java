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
        display(head);
        display(partition(head, x));
    }

    private static ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(-1);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(-1);
        ListNode after = afterHead;
        ListNode current = head;

        while(null != current){
            if(current.val < x){
                before.next = current;
                before = before.next;
            }else{
                after.next = current;
                after = after.next;
            }
            current = current.next;
        }

        before.next = afterHead.next;
        after.next = null;
        return beforeHead.next;

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
