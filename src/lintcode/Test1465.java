package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-8-18.
 * @description order-of-tasks
 * idea:
 *      这题的trick就在于排序的规则 对于每个任务对应的时间和概率　
 *      以t=[1,2],p=[0.3,0.7]为例　要所需的时间最短　就要求要么快速任务成功　要么全部失败
 *      所以按比例去计算 先完成大概率事件1/0.3=10/3, 2/0.7=20/7 显然选后者所需时间较少的概率高　
 *      即按照a1*b2-a2*b1的值去排序
 */
public class Test1465 {

    public int[] getOrder(int n, int[] t, double[] p) {
        // Write your code here
        Integer[] temp = new Integer[n];
        for (int i=0;i<n;i++) temp[i] = i;
        Arrays.sort(temp, (a, b)->{
            double diff = t[a]*p[b] - t[b]*p[a];
            if (Math.abs(diff) < 0.00001) return a-b;
            if (diff < 0) return -1;
            return 1;
        });
        int[] result = new int[n];
        for (int i=0;i<n;i++) {
            result[i] = temp[i]+1;
        }
        return result;
    }
}
