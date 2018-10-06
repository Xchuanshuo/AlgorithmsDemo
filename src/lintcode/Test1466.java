package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-10-6.
 * @description best-shopping-plan
 * idea:
 *      dp 这道题也是背包问题 但是是分组背包 礼盒可能对应多个商品 所以首先就需要把
 *      礼品盒和物品进行关联起来 然后就按照01背包的解法 首先求 某个礼品盒
 *      对应的物品 能获得的最大总价值 然后求购买礼品盒能获得的最大利润 此时就
 *      也需要考虑买物品能获得的价值 最后再求花费在k 所能获取到的最大价值
 */
public class Test1466 {

    public int getAns(int n, int m, int k, int[] val, int[] cost, int[] belong) {
        // Write your code here
        List<List<Integer>> link = new ArrayList<>();
        for (int i=0;i<n;i++) {
            link.add(new ArrayList<>());
        }
        for (int i=n;i<belong.length;i++) {
            link.get(belong[i]).add(i);
        }
        int[] dp = new int[k+1];
        int[] temp = new int[k+1];
        for (int i=0;i<n;i++) {
            for (int j=0;j<=k;j++) {
                temp[j] = dp[j];
            }
            for (int j=0;j<link.get(i).size();j++) {
                int index = link.get(i).get(j);
                for (int t=k;t>=cost[index];t--) {
                    temp[t] = Math.max(temp[t], temp[t-cost[index]] + val[index]);
                }
            }
            for (int j=cost[i];j<=k;j++) {
                dp[j] = Math.max(dp[j], temp[j-cost[i]] + val[i]);
            }
        }
        int result = 0;
        for (int i=0;i<=k;i++) {
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
