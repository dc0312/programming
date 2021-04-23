package leetcode.linkedlist;

/**
 * Convert Binary Number in a Linked List to Integer
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 *
 * @author dechatur
 */

public class LeetCodeSolution1290 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        LeetCodeSolution1290 leetCodeSolution1290 = new LeetCodeSolution1290();
        System.out.println("Dec Value : " + leetCodeSolution1290.getDecimalValue(head));
    }

    public int getDecimalValue(ListNode head) {

        int sum = 0;
        int length = -1;

        ListNode temp = head;
        while (null != temp) {
            temp = temp.next;
            length++;
        }
        ListNode newTemp = head;
        while (length != -1) {
            int data = newTemp.val;
            sum = sum + ((int) Math.pow(2, length) * data);
            newTemp = newTemp.next;
            length--;
        }
        return sum;
    }

}
