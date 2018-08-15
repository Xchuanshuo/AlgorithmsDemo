package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-8-15.
 * @description longest-substring-without-repeating-characters
 * idea:
 *      记录一个字符开始的位置start(初始为0) 并用哈希表记录每一个字符对应的索引 以abcacb为例
 *      a b c a c b  遍历到3号位置时 发现a已经出现过 所以获取它的上次出现的位置 也就是0
 *      0 1 2 3 4 5  此时0>=start 所以更新start的位置为上次的位置0+1=2, 此时不重复长度为3
 *      然后遍历到4号位置 c也出现过 同理 更新start的位置为2+1=3 此时不重复长度为2
 *      最后遍历到5号位置 b重复出现 但上次出现的位置为1<start=3 说明它后面的字符也有重复的
 *      所以不做处理 以此类推 只要某个元素重复时 其上次位置的后面存在重复元素的话 这个就不做处理
 *      如果不存在重复元素 这样不重复的长度必然是当前位置与上次位置的距离 并更新字符开始的位置start
 *      继续往后 最终得出结果
 */
public class Test384 {

    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (null == s || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> maps = new HashMap<>();
        int start=0,current=0,res=Integer.MIN_VALUE;
        while (current < s.length()) {
            if (maps.containsKey(s.charAt(current))) {
                int temp = maps.get(s.charAt(current));
                if (temp >= start) {
                    start = temp+1;
                }
            }
            maps.put(s.charAt(current), current);
            res = Math.max(res, current-start+1);
            current++;
        }

        return res;
    }
}
