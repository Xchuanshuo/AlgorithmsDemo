package lintcode;

/**
 * @author Legend
 * @data by on 18-12-3.
 * @description linked-list-cycle-ii
 * idea:
 *      是否有环直接用分别用一个快、慢指针即可，重点是如何找出环的初始位置
 *      无环部分:m 有环部分:n 慢指针走了p=m+L时相遇 而此时快指针走了q=2p=m+L+(i-1)*n
 *      当i=2时(快指针走2步,慢指针走一步) 2*(m+L) = m+L+n --> m+L = n; 因为慢指针已经
 *      在环里面走了L步 所以再走m步就刚好走完一圈,也就是到达环的起点，而 m 刚好又是无环部分的长度
 *      所以只需要看头指针和慢指针相遇的位置即是环的起点位置
 */
public class Test103 {

    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head==null || head.next == null) {
            return null;
        }
        ListNode p = head.next, q = head.next.next;
        while (p != q) {
            if (p==null || q.next==null) {
                return null;
            }
            p = p.next;
            q = p.next.next;
        }
        while (head != p) {
            head = head.next;
            p = p.next;
        }
        return p;
    }
}
