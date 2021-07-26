package aliyun;

/**
 * @author Legend
 * @data by on 21-4-4.
 * @description https://developer.aliyun.com/coding/37
 *  idea:
 *      转换成为最大值的连续数组元素个数
 */
public class Test37 {

    public int solution(int n,int[] arr) {
        if (n == 0) return 0;
        int max = 0;
        for (int a : arr) max = Math.max(max, a);
        int count = 0, res = 0;
        for (int i = 0;i < n;i++) {
            if (arr[i] == max) {
                count++;
            } else {
                count = 0;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
