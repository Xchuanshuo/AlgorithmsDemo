package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Legend
 * @data by on 18-6-15.
 * @description
 */
public class Test421 {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (String str: paths) {
            if (!stack.isEmpty() && str.equals("..")) {
                stack.pop();
            } else if (!str.equals("") && !str.equals(".")
                    && !str.equals("..")) {
                stack.push(str);
            }
        }
        List<String> list = new ArrayList<>(stack);
        return "/"+String.join("/", list);
    }

    public static void main(String[] args) {
        Test421 test = new Test421();
        String path = "/a/./b/c/";
        System.out.println(test.simplifyPath(path));
    }
}
