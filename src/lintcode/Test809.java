package lintcode;

/**
 * @author Legend
 * @data by on 19-11-8.
 * @description k-th-symbol-in-grammar
 */
public class Test809 {

    public int kthGrammar(int N, int K) {
        if (K == 1) return 0;
        if (K%2 == 0) return kthGrammar(N, K / 2) == 0 ? 1 : 0;
        return kthGrammar(N, (K+1)/2);
    }
}
