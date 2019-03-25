package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 19-3-24.
 * @description convert-linked-list-to-array-list
 */
public class Test483 {

    public List<Integer> toArrayList(ListNode head) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }
}
