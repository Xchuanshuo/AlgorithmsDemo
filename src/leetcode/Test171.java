package leetcode;

/**
 * @author Legend
 * @data by on 21-7-30.
 * @description https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class Test171 {

    public int titleToNumber(String columnTitle) {
        char[] chs = columnTitle.toCharArray();
        int res = 0;
        for (int i = 0;i < chs.length;i++) {
            res = res * 26 + (chs[i] - 'A' + 1);
        }
        return res;
    }
}
