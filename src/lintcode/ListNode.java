package lintcode;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int val) {
       this.val = val;
       this.next = null;
    }

    static void nextNode(ListNode head) {
        head = head.next;
    }

    static void changeVal(ListNode head) {
        head.val = 10;
    }
}