package leetcode.linkedlist;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 */
public class LeetCode160IntersectionLL {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        ListNode ans = intersectionOfLL(headA, headB);
        ListNode ansNew = intersectionOfLLNew(headA, headB);
        System.out.println("Result : " + ans.val);
        System.out.println("Result : " + ansNew.val);
    }

    private static ListNode intersectionOfLLNew(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = null != tempA ? tempA.next : headB;
            tempB = null != tempB ? tempB.next : headA;
        }
        return tempA;
    }

    private static ListNode intersectionOfLL(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff-- > 0) {
                headA = headA.next;
            }
        } else {
            int diff = lenB - lenA;
            while (diff-- > 0) {
                headB = headB.next;
            }
        }

        while (null != headA && null != headB) {
            if (headA == headB) {
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int getLength(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (null != current) {
            current = current.next;
            count++;
        }
        return count;
    }
}
