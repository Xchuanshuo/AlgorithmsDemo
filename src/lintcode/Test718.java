package lintcode;

/**
 * @author Legend
 * @data by on 18-8-18.
 * @description repeat-string
 * idea:
 *      利用indexOf A.length>=B.length时　没有匹配到　就说明没有不存在
 */
public class Test718 {

    public int repeatedString(String A, String B) {
        // write your code here
        if (A.equals("")) return -1;
        StringBuilder builder = new StringBuilder(A);
        int count = 1;
        while (builder.length()<B.length()) {
            builder.append(A);
            count++;
        }
        if (builder.indexOf(B)>=0) return count;
        if (builder.append(A).indexOf(B)>=0) return count+1;
        return -1;
    }

}
