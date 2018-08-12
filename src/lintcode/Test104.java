package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-7-5.
 * @description merge-k-sorted-lists
 */
public class Test104 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
           this.val = val;
           this.next = null;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (null==lists || lists.size()==0) {
            return null;
        }
        while (lists.size()>1) {
            List<ListNode> newList = new ArrayList<>();
            for (int i=0;i<lists.size()-1;i++) {
                ListNode listNode = merge(lists.get(i), lists.get(i+1));
                newList.add(listNode);
            }
            if (lists.size()%2 == 1) {
                newList.add(lists.get(lists.size()-1));
            }
            lists = newList;
        }
        return lists.get(0);
    }

    private ListNode merge(ListNode listNode1, ListNode listNode2) {
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        while (listNode1!=null && listNode2!=null) {
            if (listNode1.val<listNode2.val) {
                pointer.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                pointer.next = listNode2;
                listNode2 = listNode2.next;
            }
        }
        if (listNode1 != null) {
            pointer.next = listNode1;
        }
        if (listNode2 != null) {
            pointer.next = listNode2;
        }
        return head.next;
    }
}
