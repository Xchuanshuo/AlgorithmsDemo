package leetcode;

/**
 * @author Legend
 * @data by on 21-7-12.
 * @description https://leetcode-cn.com/problems/h-index-ii/
 */
public class Test275 {

    public int hIndex(int[] citations) {
        int l = 0, r = citations.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (!helper(citations, mid)) {
                l = mid + 1;
            } else {
                if (mid == 0 || !helper(citations, mid-1)) {
                    return citations.length - mid;
                } else {
                    r = mid - 1;
                }
            }
        }
        return 0;
    }

    private boolean helper(int[] citations, int idx) {
        int cnt = citations.length - idx;
        return citations[idx] >= cnt;
    }
}
