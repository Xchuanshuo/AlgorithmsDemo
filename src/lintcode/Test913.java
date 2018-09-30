package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-9-30.
 * @description flip-game-ii
 * idea:
 *      递归+记忆化搜索 这里是要让1号玩家至少找到一种方式保证能够胜利 也就是说
 *      在1号玩家进行游戏后 2号玩家没法继续进行 所以只要满足这一条件 就说明
 *      当前的方案是可行的 过程中用Map保存每种方案
 */
public class Test913 {

    private Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String s) {
        // write your code here
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i=0;i<s.length()-1;i++) {
            if (s.charAt(i)=='+' && s.charAt(i+1)=='+') {
                String cur = s.substring(0,i)+"--"+s.substring(i+2, s.length());
                // 2号玩家没办法赢了 这种方案下1号玩家进必赢
                if (!canWin(cur)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        // 这种方案下 表示玩家不能继续游戏了 也就是不能赢了
        map.put(s, false);
        return false;
    }
}
