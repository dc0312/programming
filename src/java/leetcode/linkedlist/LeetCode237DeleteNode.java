package leetcode.linkedlist;

/**
 * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list,
 * instead you will be given access to the node to be deleted directly.
 * <p>
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 */
public class LeetCode237DeleteNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        LeetCode237DeleteNode leetCode237DeleteNode = new LeetCode237DeleteNode();
        leetCode237DeleteNode.deleteNode(head.next.next);
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
