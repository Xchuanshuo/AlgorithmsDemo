package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-6-23.
 * @description https://leetcode-cn.com/problems/stickers-to-spell-word/
 * idea:
 *      状压DP, 根据字符串长度枚举所有状态(目标字符串某个位置的字符是否存在),
 *      对于当前状态, 枚举字符串，添加没有的字符后，记录新状态需要的最少剪切次
 *      dp[newState] = min(dp[newState],dp[curState] + 1
 *
 *      优化: 对于每个状态, 无需枚举所有的字符串, 只需要枚举缺少的字符对应的即可
 *           所以需要提前保存每个字符 对应的 字符串索引
 */
public class Test691 {

//    public int minStickers(String[] stickers, String target) {
//        int n = stickers.length, m = target.length();
//        char[] chs = target.toCharArray();
//        int[][] cnts = new int[n][26];
//        for (int i = 0;i < n;i++) {
//            for (char c : stickers[i].toCharArray()) cnts[i][c-'a']++;
//        }
//        int total = 1 << m, INF = (int)1e9;
//        int[] dp = new int[total];
//        Arrays.fill(dp, INF);
//        dp[0] = 0;
//        for (int i = 0;i < total;i++) {
//            if (dp[i] == INF) continue;
//            for (int k = 0;k < n;k++) {
//                int next = i;
//                int[] cnt = cnts[k].clone();
//                for (int j = 0;j < m;j++) {
//                    if (((1<<j)&next) != 0) continue;
//                    if (cnt[chs[j]-'a'] > 0) {
//                        next |= (1 << j);
//                        cnt[chs[j]-'a']--;
//                    }
//                }
//                dp[next] = Math.min(dp[next], dp[i] + 1);
//            }
//        }
//        return dp[total-1] == INF ? -1 : dp[total - 1];
//    }

    public int minStickers(String[] stickers, String target) {
        int n = stickers.length, m = target.length();
        char[] chs = target.toCharArray();
        int[][] cnts = new int[n][26];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0;i < 26;i++) list.add(new ArrayList<>());
        for (int i = 0;i < n;i++) {
            for (char c : stickers[i].toCharArray()) {
                cnts[i][c-'a']++;
                List<Integer> cur = list.get(c-'a');
                if (cur.isEmpty() || cur.get(cur.size() - 1) != i) {
                    cur.add(i);
                }
            }
        }
        int total = 1 << m, INF = (int)1e9;
        int[] dp = new int[total];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0;i < total;i++) {
            if (dp[i] == INF) continue;
            int idx = 0, next = i;
            for (int j = 0;j < m;j++) {
                if (((1<<j)&next) == 0) {
                    idx = j; break;
                }
            }
            for (int k : list.get(chs[idx] - 'a')) {
                int[] cnt = cnts[k].clone();
                next = i;
                for (int j = 0;j < m;j++) {
                    if (((1<<j)&next) != 0) continue;
                    if (cnt[chs[j]-'a'] > 0) {
                        next |= (1 << j);
                        cnt[chs[j]-'a']--;
                    }
                }
                dp[next] = Math.min(dp[next], dp[i] + 1);
            }
        }
        return dp[total-1] == INF ? -1 : dp[total - 1];
    }
}
