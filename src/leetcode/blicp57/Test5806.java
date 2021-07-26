package leetcode.blicp57;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-7-24.
 * @description
 */
public class Test5806 {

    public List<List<Long>> splitPainting(int[][] segments) {
        long[] dif = new long[(int)1e5 + 2];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int[] seg : segments) {
            dif[seg[0]] += seg[2];
            dif[seg[1]] -= seg[2];
            treeSet.add(seg[0]);
            treeSet.add(seg[1]);
        }
        for (int i = 1;i < dif.length;i++) {
            dif[i] += dif[i-1];
        }
        List<Integer> last = new ArrayList<>(treeSet);
        List<List<Long>> result = new ArrayList<>();
        for (int i = 0;i < last.size() - 1;i++) {
            if (dif[last.get(i)] != 0) {
                List<Long> list = new ArrayList<>();
                list.add((long) last.get(i)); list.add((long) last.get(i+1));
                list.add(dif[last.get(i)]);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] segments = {{1,2,5}, {4,7,7}};
        Test5806 test = new Test5806();
        List<List<Long>> res = test.splitPainting(segments);
        System.out.println(res);
    }
}
