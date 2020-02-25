package string;

/**
 * @author Legend
 * @data by on 19-12-7.
 * @description
 */
public class Kmp {

    /**
     * @param master 主串
     * @param mlen 主串长度
     * @param pattern 模式串
     * @param plen 模式串长度
     * @return
     */
    public static int kmp(char[] master, int mlen, char[] pattern, int plen) {
        // next数组表示最长公共前后缀子串中 '前缀子串' 的最后一个字符的位置
        int[] next = getNext(pattern, plen);
        int j = 0;
        for (int i = 0;i < mlen;i++) {
            while (j > 0 && master[i] != pattern[j]) {
                j = next[j-1] + 1;
            }
            if (master[i] == pattern[j]) {
                j++;
            }
            if (j == plen) { // 找到匹配模式串的位置
                return i - plen +1;
            }
        }
        return -1;
    }

    private static int[] getNext(char[] pattern, int plen) {
        int[] next = new int[plen];
        next[0] = -1;
        int k = -1;
        for (int i = 1;i < plen;i++) {
            while (k != -1 && pattern[k + 1] != pattern[i]) {
                // 当前位置字符与已经匹配的前缀的下一个字符不相等 则去前一个位置寻找
                k = next[k];
            }
            if (pattern[k + 1] == pattern[i]) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        String pat = "AACAA";
        String txt = "ABABAABABABBAAABRAACADABRAAACAADABRA";
        int index = Kmp.kmp(txt.toCharArray(), txt.length(), pat.toCharArray(), pat.length());
        System.out.println(index);
    }
}
