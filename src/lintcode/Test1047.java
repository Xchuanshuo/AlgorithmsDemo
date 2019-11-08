package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Legend
 * @data by on 19-11-8.
 * @description special-binary-string
 */
public class Test1047 {

    public static void main(String[] args) {
        Test1047 test = new Test1047();
        System.out.println(test.makeLargestSpecial("11011000"));
    }

    public String makeLargestSpecial(String S) {
        // write your code here
        int i = 0, count = 0;
        List<String> list = new ArrayList<>();
        for (int j = 0;j < S.length();j++) {
            count += (S.charAt(j) == '1') ? 1 : -1;
            if (count == 0) {
                list.add('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0');
                i = j + 1;
            }
        }
        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
