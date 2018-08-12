package lintcode;

/**
 * @author Legend
 * @data by on 18-8-10.
 * @description output-contest-matches
 */
public class Test879 {

    public String findContestMatch(int n) {
        // write your code here
        String[] result = new String[n];
        for (int i=1;i<=n;i++) {
            result[i-1] = i+"";
        }
        while(n>1) {
            for (int i=0;i<n/2;i++){
                result[i] = "("+result[i]+","+result[n-i-1]+")";
            }
            n = n>>1;
        }
        return result[0];
    }
}
