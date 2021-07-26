package leetcode;

import lintcode.ListNode;

/**
 * @author Legend
 * @data by on 21-6-4.
 * @description https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class Test160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = (pA == null ? headB : pA.next);
            pB = (pB == null ? headA : pB.next);
        }
        return pA;
    }
}
