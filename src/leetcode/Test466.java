package leetcode;

/**
 * @author Legend
 * @data by on 21-6-16.
 * @description https://leetcode-cn.com/problems/count-the-repetitions/
 */
public class Test466 {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int idx = 0, cnt1 = 0,cnt2 = 0;
        while (cnt1 < n1){
            for (int i = 0;i < c1.length;i++) {
                if (c1[i] == c2[idx]) {
                    if (idx == c2.length - 1) {
                        idx = 0; cnt2++;
                    } else {
                        idx++;
                    }
                }
            }
            cnt1++;
        }
        return cnt2 / n2;
    }
}
