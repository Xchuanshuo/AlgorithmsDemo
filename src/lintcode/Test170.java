package lintcode;

/**
 * @author Legend
 * @data by on 19-3-24.
 * @description rotate-list
 * idea:
 *      这道题需要注意的是k的值可能大于链表的长度, 所以解法是使用快丶慢指针, 当快节点遍历到null 慢指针就是新的头节点了
 *      1.计算链表的长度 对k进行取余
 *      2.使用快丶慢指针,快指针先走k步, 然后快慢指针一起走, 直到快指针到最后一个节点
 *      (少移动1个节点是为了分别方便进行拼接和将旋转后的尾节点变为空)
 *      3.此时新的头节点实际就是慢指针的下一个节点, 然后将之前的快指针指向初始的头节点head
 *      这样就完成了拼接操作, 最后需要做的就是把慢指针.next指向null(注意前面已经保存了新的头节点, 所以可以置为null)
 */
public class Test170 {

    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode temp =  head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        k %= count;
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (k-- > 0 && fastNode != null) {
            fastNode = fastNode.next;
        }
        while (fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        fastNode.next = head;
        ListNode newHead = slowNode.next;
        slowNode.next = null;

        return newHead;
    }
}
