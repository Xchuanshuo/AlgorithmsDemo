package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-6-16.
 * @description
 */
public class Test659 {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str: strs) {
            for (char c: str.toCharArray()) {
                if (c == ':') {
                    result.append("::");
                } else {
                    result.append(c);
                }
            }
            result.append(":;");
        }
        return result.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        char[] c = str.toCharArray();
        int i=0;
        while (i < c.length) {
            if (c[i]==':') {
                if (c[i+1]==';') {
                    result.add(builder.toString());
                    builder = new StringBuilder();
                    i += 2;
                } else  {
                    builder.append(c[i]);
                    i += 2;
                }
            } else {
                builder.append(c[i]);
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test659 test = new Test659();
        String[] strings = {"lint","code","love","you"};
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        String result = test.encode(list);
        System.out.println(result);
        System.out.println(test.decode(result));
    }
}
