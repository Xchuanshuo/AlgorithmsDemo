package lintcode;

/**
 * @author Legend
 * @data by on 18-9-8.
 * @description 4-keys-keyboard
 * idea:
 *      dp 这道题当N较小时时 最多的打印次数实际就是N本身 因为全选和复制就需要2步操作
 *      直接输入数本身更加大 而对于更大的N而言 就需要比较N本身和在某个点后都使用粘贴
 *      最大的打印数量 至于在哪个地方开始进行这这一操作 就需要穷举了 假设在输入了j个数
 *      之后 以后的步骤都是粘贴的 这里就可以用dp[i]表示步数为i时最大可打印的数量 可以得出
 *      状态转移方程  dp[i]=max(dp[i], dp[j]*(i-j-1))
 */
public class Test867 {

    public int maxA(int N) {
        // write your code here
        int[] dp = new int[N+1];
        for (int i=0;i<=N;i++) {
            dp[i] = i;
            for (int j=1;j<i-2;j++) {
                dp[i] = Math.max(dp[i], dp[j]*(i-j-1));
            }
        }
        return dp[N];
    }
}
