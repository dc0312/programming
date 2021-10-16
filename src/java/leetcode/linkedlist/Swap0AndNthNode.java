package leetcode.linkedlist;

public class Swap0AndNthNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        display(swapNodes(head));
    }

    private static ListNode swapNodes(ListNode head) {
        //1. Create A dummy Node
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //2. Find the middle element.
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        ListNode pSlow = null;

        while (null != fast && null != fast.next) {
            pSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (null != fast) {
            pSlow = slow;
            slow = slow.next;
        }

        pSlow.next = null;

        ListNode sHead = slow;
        //3. Reverse the second half.
        ListNode prev = null;
        ListNode current = sHead;

        while (null != current) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        sHead = prev;

        ListNode fHalf = dummyNode.next;
        display(fHalf);
        ListNode sHalf = sHead;
        display(sHalf);

        ListNode merged = new ListNode(-1);
        ListNode temp = merged;

        while (null != fHalf && null != sHalf) {
            ListNode aNext = fHalf;
            fHalf = fHalf.next;
            ListNode bNext = sHalf;
            sHalf = sHalf.next;

            merged.next = aNext;
            merged.next.next = bNext;
            merged = merged.next.next;

        }

        return temp.next;
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
