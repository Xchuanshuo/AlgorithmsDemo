package leetcode;


/**
 * @author Legend
 * @data by on 21-7-31.
 * @description https://leetcode-cn.com/problems/maximum-score-words-formed-by-letters/
 * idea:
 *      状态压缩 先统计每个字符可用的数量 再统计每个单词需要的字母数
 *      枚举 所有单词的可选方案 取最大值即可
 */
public class Test1255 {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int[] total = new int[26];
        for (char c : letters) total[c-'a']++;
        int[][] wordCnt = new int[n][26];
        for (int i = 0;i < n;i++) {
            for (char c : words[i].toCharArray()) {
                wordCnt[i][c-'a']++;
            }
        }
        int len = 1 << n, max = 0;
        for (int i = 1;i < len;i++) {
            max = Math.max(max, helper(i, total.clone(), score, wordCnt));
        }
        return max;
    }

    private int helper(int state, int[] total, int[] score, int[][] wordCnt) {
        int n = wordCnt.length, sum = 0;
        for (int i = 0;i < n;i++) {
            if ((state & (1<<i)) == 0) continue;
            for (int j = 0;j < 26;j++) {
                if (wordCnt[i][j] > total[j]) return 0;
                sum += wordCnt[i][j] * score[j];
                total[j] -= wordCnt[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Test1255 test = new Test1255();
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int res = test.maxScoreWords(words, letters, score);
        System.out.println(res);
    }
}
