package lintcode;

/**
 * @author Legend
 * @data by on 18-6-16.
 * @description
 */
public class Test512 {

    public int numDecodings(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int result[] = new int[s.length()+1];
        result[0] = 1;
        result[1] = s.charAt(0)=='0'?0:1;
        for (int i=2;i <= s.length();i++) {
            if (s.charAt(i-1)!='0') {
                result[i] = result[i-1];
            }
            //　计算相邻的两个数字
            int two = (s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
            if (two>=10 && two<=26) {
                result[i] += result[i-2];
            }
        }
        return result[s.length()];
    }

    public static void main(String[] args) {
        Test512 test = new Test512();
        String s = "122";
        System.out.println(test.numDecodings(s));
    }
}
