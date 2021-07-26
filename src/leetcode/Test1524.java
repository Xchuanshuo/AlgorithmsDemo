package leetcode;

/**
 * @author Legend
 * @data by on 21-7-14.
 * @description https://leetcode-cn.com/problems/number-of-sub-arrays-with-odd-sum/
 * idea:
 *      奇数 - 偶数 = 奇数
 *      以当前数结尾的前缀和为偶数时, 只需要看前面的奇数前缀和个数 任选一个相减 子数组为奇数
 *      以当前数结尾的前缀和为奇数时, 只需要看前面的偶数前缀和个数 任选一个相减 子数组为奇数
 */
public class Test1524 {

    public int numOfSubarrays(int[] arr) {
        int n = arr.length, M = (int) 1e9 + 7;
        int even = 1, odd = 0;
        int s = 0, res = 0;
        for (int i = 0;i < n;i++) {
            s += arr[i];
            if (s%2 == 0) {
                even++;
                res = (res + odd)%M;
            } else {
                odd++;
                res = (res + even)%M;
            }
        }
        return res;
    }
}
