package leetcode;

/**
 * @author Legend
 * @data by on 21-6-18.
 * @description https://leetcode-cn.com/problems/kth-smallest-instructions/
 * idea:
 *      第k条最小指令 -> dest(row,column), row个V与column个H组成的第k小的字符串序列
 *      排列组合  假设首字符为H, 则总的摆放方案数为 o = c(h-1+v, h-1)
 *                即从[h-1+v]个字符中取[h-1]个字符的方案数, 对于方案数o
 *              1.若 k > o, 说明第一位不能放H,只能放V, 那么此时变成了子问题
 *                dest(v-1,h), 在该子问题中 k的位置应该为 [k - o]
 *              2.若 k < o, 说明此时目标指令就在第1位放H的方案中, 此时变成了
 *                求解子问题(v,h-1), 在此子问题中, 位置仍然为k
 *      重复上述1,2步骤即可, 直到H或V的剩余数量为0
 *
 *      对于求解组合数 可以先预处理 使用公式 c(n,m)=c(n-1,m-1) + c(n-1,m)
 */
public class Test1643 {

    public String kthSmallestPath(int[] destination, int k) {
        int rows = destination[0], cols = destination[1];
        int h = cols, v = rows;
        int[][] dp = new int[h+v][h];
        dp[0][0] = 1;
        for (int i = 1;i < h + v;i++) {
            dp[i][0] = 1;
            for (int j = 1;j <= i && j < h;j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        while (h > 0 && v > 0) {
            int low = dp[h-1+v][h-1];
            if (k > low) {
                v--;
                sb.append("V");
                k -= low;
            } else {
                h--;
                sb.append("H");
            }
        }
        if (h != 0) {
            while (h-- > 0) sb.append("H");
        } else  {
            while (v-- > 0) sb.append("V");
        }
        return sb.toString();
    }
}
