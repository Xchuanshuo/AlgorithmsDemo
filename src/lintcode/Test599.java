package lintcode;

/**
 * @author Legend
 * @data by on 19-3-25.
 * @description insert-into-a-cyclic-sorted-list
 * idea:
 *      找插入点时注意有两种情况
 *      1. 刚好在链表里面(不是头节点和尾节点连接处) 满足比前一个值大 后一个值小即可
 *      2. 头节点和尾节点连接处 此时有两种可能 一种是比尾节点更加大 一种是比头节点更加小
 */
public class Test599 {

    public ListNode insert(ListNode node, int x) {
        // write your code here
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        ListNode pre;
        ListNode cur = node;
        do {
            pre = cur;
            cur = cur.next;
            if (x >= pre.val && x <= cur.val) {
                break;
            }
            if (cur.val < pre.val && (x > pre.val || x < cur.val)) {
                break;
            }
        } while (cur != node);
        ListNode newNode = new ListNode(x);
        pre.next = newNode;
        newNode.next = cur;
        return newNode;
    }
}
