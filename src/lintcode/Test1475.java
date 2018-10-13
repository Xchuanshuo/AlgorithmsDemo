package lintcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-10-13.
 * @description minimum-legal-bracket-sequence
 * idea:
 *      这道题首先假设 把所有的'?'全部替换成')' 并计算替换的所需的总代值 然后再把其中
 *      的')'替换成'(' 此时需要的代价为diff=a[i]-b[i] diff+之前的总代价=替换后的总代价
 *      那么如何找最小的替换代价呢？ 直接把替换后的diff值放如到一个最小堆中 堆顶总是最小的
 *      数 那么直接从堆顶拿到值diff+之前总代价 必定是当前情况下最小的总替换代价. 在过程中
 *      还需要统计 当前的左括号和右括号数量 不能刚好构成合法序列时才进行‘)’->'('操作
 */
public class Test1475 {

    public int getAnswer(char[] s, int[] a, int[] b) {
        // Write your code here
        int n = s.length, result = 0, count = 0;
        int[] pos = new int[n+1];
        for (int i=0;i<n;i++) {
            if (s[i] == '?') {
                pos[i] = count++;
                result += b[pos[i]];
            }
        }
        count = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        boolean flag = true;
        for (int i=0;i<n;i++) {
            if (s[i] == '(') {
                count++;
            } else {
                count--;
            }
            if (s[i] == '?') queue.offer(a[pos[i]]-b[pos[i]]);
            if (count < 0 && !queue.isEmpty()) {
                result += queue.poll();
                count += 2;
            }
            if (count < 0) {
                flag = true;
                break;
            }
        }
        if (count>0 || !flag) return -1;
        return result;
    }
}
