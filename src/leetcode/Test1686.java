package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-5.
 * @description https://leetcode-cn.com/problems/stone-game-vi/
 * idea:
 *      贪心, 使用最优策略需要考虑两个方面
 *      1.让自己获得分数尽可能多 2.让对方获得分数尽可能少
 *      所以可以直接根据alice[i]+bob[i]的值从大到小排序
 *      偶数时alice取 奇数时bob取 最后比较两者分数即可
 */
public class Test1686 {

    public int stoneGameVI(int[] alice, int[] bob) {
        int n = alice.length;
        int[][] arr = new int[n][3];
        for (int i = 0;i < n;i++) {
            arr[i] = new int[]{alice[i] + bob[i], alice[i], bob[i]};
        }
        Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);
        int a = 0, b = 0;
        for (int i = 0;i < n;i++) {
            if (i%2 == 0) {
                a += arr[i][1];
            } else {
                b += arr[i][2];
            }
        }
        if (a == b) return 0;
        return a > b ? 1 : -1;
    }
}
