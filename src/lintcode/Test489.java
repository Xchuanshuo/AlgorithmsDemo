package lintcode;

import java.util.List;

/**
 * @author Legend
 * @data by on 19-3-24.
 * @description convert-array-list-to-linked-list
 */
public class Test489 {

    public ListNode toLinkedList(List<Integer> nums) {
        // write your code here
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        for (int i = 0;i < nums.size();i++) {
            cur.next = new ListNode(nums.get(i));
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
