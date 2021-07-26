package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-7-11.
 * @description https://leetcode-cn.com/problems/h-index/
 */
public class Test274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0;i < citations.length;i++) {
            int cnt = citations.length - i;
            if (citations[i] >= cnt) {
                return cnt;
            }
        }
        return 0;
    }
}
