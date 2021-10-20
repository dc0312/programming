package leetcode.linkedlist;

public class LeetCode83RemoveDuplicates {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        display(head);

        display(removeDuplicates(head));
    }

    public static ListNode removeDuplicates(ListNode head) {
        ListNode list = head;

        while (null != list) {
            if(null == list.next){
                break;
            }
            if(list.next.val == list.val){
                list.next = list.next.next;
            }else{
                list = list.next;
            }
        }
        return head;
    }

    public static void display(ListNode head) {
        ListNode temp = head;
        while (null != temp) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }
}
