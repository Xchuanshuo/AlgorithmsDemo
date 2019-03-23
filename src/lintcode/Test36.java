package lintcode;

/**
 * @author Legend
 * @data by on 19-3-23.
 * @description reverse-linked-list-ii
 * idea:
 *      二刷 这道题没看之前的答案 先说下做法 三步
 *      1.首先头节点遍历到m的前一个
 *      2.从m-n进行翻转 拿到翻转后的头节点pre ,将之前的头节点拼接上pre, 注意此时的head节点变为了n后的第一个节点
 *      3.可以pre直接遍历到尾节点为空时 拼接上经过第2步操作的head, 更好的做法是保存第需要翻转开始节点的地址
 *      如 1->2->3->4->null 假设从第2-3个节点翻转 结果为1->3->2->4->null 所以直接保存节点2的地址
 *      翻转后就可以直接拼接节点4无需遍历
 *      其实关键在于解决翻转的起始节点的问题, 如果是m=1的话其实不需要分段去拼接,
 *      这样代码就不是很好写了 这里就想到了把虚拟头节点再复制一份res, 因为虚拟头节点不是从需要操作的链表的head开始的
 *      所以拼接时直接使用res进行拼接, 这样就能写出通用性的代码了
 */
public class Test36 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 复制一份虚拟头节点
        ListNode res = dummy;
        for (int i = 1;i < m;i++) {
            head = head.next;
            res = res.next;
        }
        // 翻转
        ListNode pre = null, firstNode = head;
        for (int i = m; i <= n;i++) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        // 拼接前一部分
        res.next = pre;
        // 拼接后一部分
        firstNode.next = head;
        return dummy.next;
    }
}
