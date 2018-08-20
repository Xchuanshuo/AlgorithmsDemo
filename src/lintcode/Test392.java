package lintcode;

/**
 * @author Legend
 * @data by on 18-8-20.
 * @description house-robber
 * idea:
 *      可以用动态规划 但其实每次的结果就依赖与前面一次的结果 所以可以直接用
 *      贪心算法
 */
public class Test392 {

    public long houseRobber(int[] A) {
        // write your code here
        int n = A.length;
        if(n == 0)
            return 0;

        long curMax = 0, preMax = 0;
        for(int i = 0 ; i < n ; i ++) {
            long temp = curMax;
            curMax = Math.max(curMax, A[i] + preMax);
            preMax = temp;
        }
        return curMax;
    }

    public long houseRobber1(int[] A) {
        // write your code here
        int n = A.length;
        if(n == 0)
            return 0;
        long []res = new long[n+1];


        res[0] = 0;
        res[1] = A[0];
        for(int i = 2; i <= n; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + A[i-1]);
        }
        return res[n];
    }
}
