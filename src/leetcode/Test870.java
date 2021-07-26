package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-4-24.
 * @description https://leetcode-cn.com/problems/advantage-shuffle/
 * idea:
 *      贪心算法, 将A、B数组从小到大排序, 然后从头到尾比较大小, A的当前元素比B大
 *      则添加到与B比赛的队列中，小于等于则先保存到一个队列,继续看A后面的元素,
 *      当考察完A所有元素 最后看B还剩余几个, 再将保存到队列中的A与B的剩余数字任意组合即可
 */
public class Test870 {

    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedB = B.clone();
        Arrays.sort(A);
        Arrays.sort(sortedB);
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(sortedB));
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int b : sortedB) map.put(b, new LinkedList<>());
        int j = 0;
        for (int a : A) {
            if (a > sortedB[j]) {
                map.get(sortedB[j]).add(a);
                j++;
            } else {
                q.offer(a);
            }
        }
        while (j < A.length) {
            map.get(sortedB[j]).add(q.poll());
            j++;
        }
        int[] res = new int[A.length];
        int i = 0;
        for (int b : B) {
            res[i++] = map.get(b).poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {8,2,4,4,5,6,6,0,4,7};
        int[] B = {0,8,7,4,4,2,8,5,2,0};
        Test870 test870 = new Test870();
        int[] res = test870.advantageCount(A, B);
        System.out.println(Arrays.toString(res));
    }
}
