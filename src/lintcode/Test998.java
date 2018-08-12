package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-8-11.
 * @description construction-queue
 * idea:
 *      只需要用把原来的数和对应的位置建立一个映射
 *      这样会出现一种情况，就是前面有0个比自身大的数会有重复
 *      只需要使用TreeMap来进行映射, 这样先映射的数肯定是比较小的
 *      比较大的数再映射的时候还是放在索引0号位置 之前的数就会放到后面去
 *      还是题目的满足条件 最后就能得出全部的解
 */
public class Test998 {

    public int[] getQueue(int n, int[] arr1, int[] arr2) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] result = new int[arr1.length];
        for (int i=0;i<arr1.length;i++) {
            map.put(arr1[i], arr2[i]);
        }
        for (int num: map.keySet()) {
            list.add(map.get(num), num);
        }
        for (int i=0;i<result.length;i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Test998 test = new Test998();
        // 3 1 5 2 4
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {0, 1, 0, 3, 2};
        int[] result = test.getQueue(4, arr1, arr2);
        for (int i: result) {
            System.out.print(i+", ");
        }
    }
}
