package aliyun;

/**
 * @author Legend
 * @data by on 21-4-4.
 * @description https://developer.aliyun.com/coding/44
 * idea:
 *      所有元素直接跟最大值连接
 */
public class Test44 {

    public int solution(int n,int[] nums) {
        if (n == 0) return 0;
        int max = 0, idx = 0;
        for (int i =  0;i < n;i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }
        int res = 0;
        for (int i = 0;i < n;i++) {
            if (i != idx) {
                res += (nums[idx] + nums[i]) / 2;
            }
        }
        return res;
    }
}
