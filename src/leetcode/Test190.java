package leetcode;

/**
 * @author Legend
 * @data by on 21-3-29.
 * @description
 */
public class Test190 {

    public int reverseBits(int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 32 - str.length();i++) {
            sb.append("0");
        }
        sb.append(str);
        return (int) Long.parseLong(sb.reverse().toString(), 2);
    }

    public static void main(String[] args) {
        Test190 test190 = new Test190();
        int res = test190.reverseBits(-3);
        System.out.println(res);
    }
}
