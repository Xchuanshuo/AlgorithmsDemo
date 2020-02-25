package string;

/**
 * @author Legend
 * @data by on 19-12-3.
 * @description BM算法
 */
public class BoyerMoore {

    private static final int SIZE = 256;

    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE];
        generateBC(b, m, bc);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        int i = 0; // 表示主串与模式串对齐的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1;j >= 0;j--) {
                if (a[i + j] != b[j]) break;
            }
            if (j < 0) return i; // 匹配成功
            // 滑动到与主串不匹配字符所在模式串中存在的最后一个位置
            int x = j - bc[(int) a[i+j]];
            int y = 0;
            if (j < m - 1) {
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j; // 好后缀长度
        if (suffix[k] != -1) return j - suffix[k] + 1;
        // 从j+2开始 是由于前面已经判断了有公共前缀子串的情况
        // 到这里肯定是没有了 所以找前缀子串直接跳过1位即可
        for (int r = j + 2;r <= m-1;++r) {
            if (prefix[m - r] = true) return r;
        }
        return m;
    }

    /**
     * 坏字符
     * @param b
     * @param m
     * @param bc
     */
    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0;i < m;i++) {
            bc[i] = -1;
        }
        for (int i = 0;i < m;i++) {
            int ascii = (int) b[i]; // 对每个字符的ascii码值做映射
            bc[ascii] = i;
        }
    }

    /**
     * 好后缀
     * @param b
     * @param m
     * @param suffix
     * @param prefix
     */
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0;i < m;i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0;i < m - 1;i++) {
            int j = i;
            int k = 0; // 公共后缀子串长度
            while (j >= 0 && b[j] == b[m - 1 - k]) {
                j--;
                k++;
                suffix[k] = j + 1;
            }
            if (j == -1) prefix[k] = true;
        }
    }

}
