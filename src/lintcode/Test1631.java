package lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-10-13.
 * @description interesting-subarray
 * idea:
 *      两种解法 第一种 暴力求解 时间复杂度为O(N^2); 第二种, 使用两个变量p1,p2分别记录
 *      出现的值不超过两个值左边的索引,当前值和前一个值不相等时,当前的索引 还需要一个变量
 *      v记录两个值中前一个值 如果当前的值a[i]和a[i-1]不相等 就去看当前的值与v是否相等
 *      也不相等的话就需要更新 使p1=p2 此时相当于有三个不相等的值了 所以直接跳过第一个
 *      这种方式时间复杂度为O(N)
 */
public class Test1631 {

    public int maxLen(int[] a) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        int j, max=0;
        for (int i=0;i<a.length-1;i++) {
            set.clear();
            for (j=i;j<a.length;j++) {
                set.add(a[j]);
                if (set.size() > 2) break;
            }
            max = Math.max(max, j-i);
        }
        return max;
    }

    /**
     *  1 2 1 3
     *  v=1 p2=1 p1=0 max=2
     *  p2=2 v=2 p1=0 max=3
     *  p2=3 v=1 p1=2 max=3
     * @param a
     * @return
     */
    public int maxLen1(int[] a) {
        // Write your code here
        if (a==null || a.length==0) return 0;
        int v = a[0], p1=0, p2=0, max=0;
        for (int i=1;i<a.length;i++) {
            if (a[i] != a[i-1]) {
                if (a[i] != v) p1 = p2;
                p2 = i;
                v = a[i-1];
            }
            max = Math.max(max, i-p1+1);
        }
        return max;
    }
}
