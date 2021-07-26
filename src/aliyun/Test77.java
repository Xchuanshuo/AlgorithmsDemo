package aliyun;

/**
 * @author Legend
 * @data by on 21-4-8.
 * @description https://developer.aliyun.com/coding/77
 */
public class Test77 {

    public int solution(int n, int m, int[] a, int[] b) {
        int res = 0;
        int i = 0, j = 0;
        int sa = 0, sb = 0;
        while (i < n || j < m) {
            if (sa == sb) {
                sa += a[i++];
                sb += b[j++];
                res++;
            } else if (sa < sb && i <n) {
                sa += a[i++];
            } else if (j < m){
                sb += b[j++];
            }
            if (i == n && j == m && sa == sb) return res;
        }
        return -1;
    }
}
