package lintcode;

/**
 * @author Legend
 * @data by on 18-6-14.
 * @description
 * idea:
 *      Manacher算法 可以看看博客链接
 *      http://blog.cspojie.cn/2018/06/16/Manacher%E7%AE%97%E6%B3%95%E6%B1%82%E8%A7%A3%E6%9C%80%E9%95%BF%E5%9B%9E%E6%96%87%E5%AD%90%E4%B8%B2/#more
 */
public class Test200 {

    public String longestPalindrome(String s) {
        // write your code here
        StringBuilder builder = new StringBuilder();
        builder.append("&#");
        char[] c = s.toCharArray();
        for (int i=0;i < c.length;i++) {
            builder.append(c[i]+"#");
        }
        String newStr = builder.toString();
        c = newStr.toCharArray();
        // 回文半径
        int[] r = new int[newStr.length()];
        // 回文子串最大右端点、中心点
        int right=0, center=0;
        // 最大回文半径、最大中心点
        int maxR=0, maxC=0;

        for (int i=1;i < c.length;i++) {
            r[i]=right>i?(Math.min(r[2*center-i], right-i)):1;
            while (i+r[i]<c.length && c[i+r[i]]==c[i-r[i]]) {
                ++r[i];
            }
            // 更新右端点和中心点
            if (right < i+r[i]) {
                right = i+r[i];
                center = i;
            }
            if (maxR < r[i]) {
                maxR = r[i];
                maxC = i;
            }
        }
        int start = (maxC-maxR)/2;
        return s.substring(start, start+maxR-1);
    }

    public static void main(String[] args) {
        String s = "aa";
        Test200 test = new Test200();
        System.out.println(test.longestPalindrome(s));
    }
}
