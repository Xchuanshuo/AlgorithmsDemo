package lintcode;

/**
 * @author Legend
 * @data by on 18-6-17.
 * @description
 */
public class Test408 {

    public String addBinary1(String a, String b) {
        // write your code here
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        int sum = a1 + b1;
        return Integer.toString(sum, 2);
    }

    public String addBinary(String a, String b) {
        String result = "";
        int carry = 0;
        for (int i=a.length()-1, j=b.length()-1;i>=0||j>=0;i--, j--) {
            int sum = carry;
            sum += i>=0?a.charAt(i)-'0': 0;
            sum += j>=0?b.charAt(j)-'0': 0;
            result = sum%2 + result;
            carry = sum/2;
        }
        if (carry != 0) {
            result = carry + result;
        }
        return result;
    }

    public static void main(String[] args) {
        Test408 test = new Test408();
        String a = "1001", b = "1";
        System.out.println(test.addBinary(a, b));
    }
}
