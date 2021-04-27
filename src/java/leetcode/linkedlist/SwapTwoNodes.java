package leetcode.linkedlist;

public class SwapTwoNodes {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        display(head);
        swap(head);
        display(head);
    }

    private static void display(ListNode head) {
        ListNode temp = head;
        while (null != temp) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    private static void swap(ListNode head) {
        ListNode currentNode = head;
        while (null != currentNode && null != currentNode.next) {
            swapData(currentNode);
            currentNode = currentNode.next.next;
        }
    }

    private static void swapData(ListNode currentNode) {
        int temp = currentNode.val;
        currentNode.val = currentNode.next.val;
        currentNode.next.val = temp;
    }
}
