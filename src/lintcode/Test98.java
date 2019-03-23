package lintcode;


/**
 * @author Legend
 * @data by on 19-3-22.
 * @description sort-list
 * idea: 题目要求O(nlogn) 所以用快排和归并排序都可以, 对于归并排序，这里找中点的方法是使用，快慢指针
 *        注意快指针先走一步, 避免链表只有两个节点时 如 1->2->null 应该返回的是1, 如果返回2会导致
 *        右半边为null节点 则无法将元素进行比较 左半边则会一直 以同样的方式切分, 直到栈溢出...
 */
public class Test98 {

    // 归并
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = findMid(head);
        ListNode right = sortList(midNode.next);
        midNode.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }

    public ListNode findMid(ListNode head) {
        ListNode slowNode = head;
        ListNode quickNode = head.next;
        while (quickNode != null && quickNode.next != null) {
            slowNode = slowNode.next;
            quickNode = quickNode.next.next;
        }
        return slowNode;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        return dummyHead.next;
    }

    // 快排

    public void quickSort(ListNode start, ListNode end) {
        if (start == end) {
            return;
        }
        ListNode p = partition(start, end);
        quickSort(start, p);
        quickSort(p.next, end);
    }

    private ListNode partition(ListNode start, ListNode end) {
        int pivot = start.val;
        ListNode p1 = start, p2 = start.next;
        while (p2 != end) {
            if (p2.val < pivot) {
                p1 = p1.next;
                swap(p1, p2);
            }
            p2 = p2.next;
        }
        swap(p1, start);
        return p1;
    }

    private void swap(ListNode p1, ListNode p2) {
        int temp = p1.val;
        p1.val = p2.val;
        p2.val = temp;
    }
}
