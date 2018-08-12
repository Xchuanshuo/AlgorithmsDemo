package string;

/**
 * @author Legend
 * @data by on 18-6-9.
 * @description KMP算法
 */
public class KMP {

    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int i=1;i < M;i++) {
            // 设置匹配成功情况下的值
            dfa[pat.charAt(i)][i] = i+1;
            // 更新开始的状态
            //X = dfa[pat.charAt(i)][X];
        }
    }

    public int search(String txt) {
        int N = txt.length(), M = pat.length();
        int i,j;
        for (i=0,j=0;i<N && j<M;i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) {
            //　找到匹配　
            return i-M;
        } else {
            // 未找到匹配
            return N;
        }
    }

    public static void main(String[] args) {
        String pat = "AACAA";
        String txt = "ABABAABABABBAAABRAACADABRAACAADABRA";
        KMP kmp = new KMP(pat);
        System.out.println(kmp.search(txt));
    }
}
