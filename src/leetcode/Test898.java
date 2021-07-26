package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 21-5-16.
 * @description https://leetcode-cn.com/problems/bitwise-ors-of-subarrays/submissions/
 * idea:
 *      暴力: 从后往前 计算以当前i结尾的子数组的按位或结果 并保存j位置到i位置的按位或结果
 *      剪枝: 如果当前位置(j到i-1的结果 & arr[i]) == arr[i], 说明当前数对于按位或结果
 *            没有任何贡献了, 那么j前面的位置开始到i-1的按位或结果,同样不会有任何变化了
 */
public class Test898 {

    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < n;i++) {
            set.add(arr[i]);
            for (int j = i - 1;j >= 0;j--) {
                if  ((arr[j]&arr[i]) == arr[i]) break;
                arr[j] |= arr[i];
                set.add(arr[j]);
            }
        }
        return set.size();
    }
}
