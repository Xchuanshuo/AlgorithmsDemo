package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 18-7-4.
 * @description decode-string
 */
public class Test575 {

    class Helper {
        StringBuilder builder = new StringBuilder();
        int count  = 0;
    }

    public String expressionExpand(String s) {
        // write your code here
        Stack<Helper> stack = new Stack<>();
        Helper helper = new Helper();
        for (char c: s.toCharArray()) {
            if (c=='[') {
                stack.add(helper);
                helper = new Helper();
            } else if (c==']') {
                String str = helper.builder.toString();
                helper = stack.pop();
                for (int i=0;i<helper.count;i++) {
                    helper.builder.append(str);
                }
                helper.count = 0;
            } else if (Character.isDigit(c)) {
                helper.count = helper.count*10 + c-'0';
            } else {
                helper.builder.append(c);
            }
        }
        return helper.builder.toString();
    }
}
