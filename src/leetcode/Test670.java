package leetcode;

/**
 * @author Legend
 * @data by on 21-4-17.
 * @description https://leetcode-cn.com/problems/maximum-swap/
 * idea:
 *      贪心 1.首先保存每个元素最后出现的位置
 *          2.遍历所有元素，看当前元素后面是否存在比
 *          当前元素更大的元素 找到最大元素进行交换 得到结果
 */
public class Test670 {

    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] pos = new int[10];
        for (int i = 0;i < chars.length;i++) {
            pos[chars[i] - '0'] = i;
        }
        for (int i = 0;i < chars.length - 1;i++) {
            for (int j = 9;j > chars[i] - '0';j--) {
                if (pos[j] > i) {
                    char t = chars[i];chars[i] = chars[pos[j]]; chars[pos[j]] = t;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}
