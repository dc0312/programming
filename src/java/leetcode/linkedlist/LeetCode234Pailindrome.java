package leetcode.linkedlist;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 */
public class LeetCode234Pailindrome {

    /**
     * This method has O(n) space and O(n) timing
     *
     * @param head
     * @return
     */
//    public static boolean isPalindrome(ListNode head) {
//        Stack st = new Stack();
//        ListNode fast = head;
//        ListNode slow = head;
//
//        while (null != fast && null != fast.next) {
//            st.push(slow.val);
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        if(null != fast){
//            slow = slow.next;
//        }
//        while (null != slow){
//            if(st.isEmpty()){
//                return false;
//            }
//            if((int)st.pop() != slow.val){
//                return false;
//            }
//            slow = slow.next;
//
//        }
//        return true;
//    }

    /**
     * This method has O(n) time and O(1) space complexity.
     */
//    public static boolean isPalindrome(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        ListNode newHead = null;
//        while (null != fast && null != fast.next) {
//            fast = fast.next.next;
//            ListNode next = slow.next;
//            slow.next = newHead;
//            newHead = slow;
//            slow = next;
//        }
//
//        if (null != fast) {
//            slow = slow.next;
//        }
//
//        while (null != newHead || null != slow) {
//            if (newHead.val != slow.val) {
//                return false;
//            }
//            newHead = newHead.next;
//            slow = slow.next;
//        }
//        return true;
//    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(1);
        System.out.println("Is palindrome ? " + isPalindrome(head));
    }


    private static boolean isPalindrome(ListNode head) {
        //1. Find the middle element
        ListNode slow = head;
        ListNode fast = head;
        ListNode pSlow = null;

        while (null != fast && null != fast.next) {
            pSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //2. Break the linked list into two halves
        if (fast != null) {
            pSlow = slow;
            slow = slow.next;
        }
        pSlow.next = null;
        ListNode sHead = slow;

        //3. Reverse the second half of the linked list
        ListNode prev = null;
        ListNode current = sHead;
        while (null != current) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        sHead = prev;
        //4. Compare the first and reversed second half of the list
        ListNode fHalf = head;
        ListNode sHalf = sHead;

        while (null != fHalf && null != sHalf) {
            if (fHalf.val != sHalf.val) {
                return false;
            }
            fHalf = fHalf.next;
            sHalf = sHalf.next;
        }
        return true;
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
