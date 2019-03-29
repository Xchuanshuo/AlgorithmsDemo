package lintcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-3-29.
 * @description remove-duplicate-letters
 * idea:
 *      挺trick的题... 容易出问题的点很多 统计的字符数 以及访问情况需要及时更新
 */
public class Test834 {

    public String removeDuplicateLetters(String s) {
        // write your code here
        if (s == null) return s;
        // 统计每个字符数目
        int[] count = new int[123];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        // 看当前字符是否访问过
        Set<Character> visited = new HashSet<>();
        // 保存使字典序最小的字符序列
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (visited.contains(c)) {
                count[c]--;
                continue;
            }
            // 当前字符小于栈顶的元素 并且栈顶字符出现多次 就把当前的栈顶移除掉
            // 保证了以最小字典序的方式 去进行移除 空出的最佳位置留给当前字符
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek()]>1) {
                count[stack.peek()]--;
                // 这里因为是移除了重复字符 所以要标记为未访问过 后续再遇到该字符就不会被过滤掉
                visited.remove(stack.peek());
                stack.pop();
            }
            visited.add(c);
            stack.push(c);
        }
        char[] temp = new char[stack.size()];
        for (int i = temp.length - 1;i >= 0;i--) {
            temp[i] = stack.pop();
        }
        return new String(temp);
    }

}
