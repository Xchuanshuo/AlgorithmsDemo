package leetcode;

/**
 * @author Legend
 * @data by on 21-5-16.
 * @description https://leetcode-cn.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/
 */
public class Test5760 {

    public int minSwaps(String S) {
        char[] s = S.toCharArray();
        int[] cnt = new int[2];
        for (char c : s) cnt[c-'0']++;
        if (Math.abs(cnt[0] -cnt[1]) > 1) return -1;
        if (cnt[1] > cnt[0]) return to101(s);
        if (cnt[1] < cnt[0]) return to010(s);
        return Math.min(to010(s.clone()), to101(s.clone()));
    }

    private int to101(char[] s) {
        int l = 0, r = s.length - 1;
        int i = 0, j = r;
        int res = 0;
        while (i < j) {
            while (i != r && s[i] == (((i^1)&1)+'0')) i++;
            while (j != l && s[j] == (((j^1)&1)+'0')) j--;
            if (i < j) {
                res++;
                s[i] =(char) (((i^1)&1)+'0') ;
                s[j] =(char) (((j^1)&1)+'0') ;
            }
        }
        return res;
    }

    private int to010(char[] s) {
        int l = 0, r = s.length - 1;
        int i = 0, j = r;
        int res = 0;
        while (i< j) {
            while (i != r && s[i] == ((i&1)+'0')) i++;
            while (j != l && s[j] == ((j&1)+'0')) j--;
            if (i < j) {
                res++;
                s[i] =(char) ((i&1)+'0') ;
                s[j] =(char) ((j&1)+'0') ;
            }
        }
        return res;
    }
}
