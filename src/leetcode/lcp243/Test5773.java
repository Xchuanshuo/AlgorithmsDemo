package leetcode.lcp243;

/**
 * @author Legend
 * @data by on 21-5-30.
 * @description
 */
public class Test5773 {

    public String maxValue(String n, int x) {
        boolean ne = (n.charAt(0) == '-');
        if (ne) n = n.substring(1);
        char[] chs = n.toCharArray();
        int idx = 0;
        if (!ne) {
            while (idx < chs.length) {
                if (chs[idx]-'0' < x) {
                    break;
                }
                idx++;
            }
        } else {
            while (idx < chs.length) {
                if (chs[idx]-'0' > x) {
                    break;
                }
                idx++;
            }
        }
        String str = n.substring(0, idx) + x + n.substring(idx);
        return ne ? "-" + str : str;
    }

    public static void main(String[] args) {
        String s = "28824579515";
        Test5773 Test5773 = new Test5773();
        System.out.println(Test5773.maxValue(s, 8));
    }
}
