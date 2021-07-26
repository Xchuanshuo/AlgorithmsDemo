package aliyun;

/**
 * @author Legend
 * @data by on 21-4-6.
 * @description https://developer.aliyun.com/coding/74
 * idea:
 *      根据示例 1,1,2,3 可以得到2^1 2^1 2^2 2^3 其中2个2^1可以变成 2^2
 *      此时2个2^2又可以变成2^3 剩余2个2^3 变成一个2^4
 *      根据规律可以得出，偶数个(设为m)2^k可以凑成 m/2个 2^(k+1)
 *                     若共有奇数个2^k，则最后剩余一个2^k没办法继续凑
 *      此时就需要将总的钱币数+1
 *      解法：1.统计每个数的数量 count[]
 *           2.count[i+1]+=count[i]/2
 *           3.若当前数i的个数为奇数 则总钱币数+1
 */
public class Test74 {

    public int solution(int n, int[] m) {
        int max = 0;
        for (int i = 0;i < n;i++) {
            max = Math.max(max, m[i]);
        }
        int[] arr = new int[max+2];
        for (int v : m) arr[v]++;
        int res = 0;
        for (int i = 0;i <= max;i++) {
            if (arr[i] == 0) continue;
            if (arr[i]%2 == 1) res++;
            arr[i+1] += arr[i]/2;
        }
        if (arr[max+1] != 0) res++;
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] m = {1, 1, 2, 3};
        Test74 test74 = new Test74();
        int res = test74.solution(n, m);
        System.out.println(res);
    }
}
