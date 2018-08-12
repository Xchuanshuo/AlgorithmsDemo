package lintcode;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-6-29.
 * @description merge-k-sorted-arrays
 */
public class Test486 {


    class Helper {
        int arr[];
        int index;
        public Helper(int arr[], int index) {
            this.arr = arr;
            this.index = index;
        }
    }

    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        if (null == arrays || arrays[0].length==0 || arrays.length==0) {
            return new int[]{};
        }
        Queue<Helper> queue = new PriorityQueue<>(arrays.length, Comparator.comparingInt(o -> o.arr[o.index]));
        int n = 0;
        for (int i=0;i<arrays.length;i++) {
            queue.add(new Helper(arrays[i],0));
            n += arrays[i].length;
        }
        int m=0;
        int[] result = new int[n];
        while(!queue.isEmpty()) {
            Helper helper = queue.poll();
            result[m++] = helper.arr[helper.index];
            // 只要当前数组没遍历到最后一个索引　继续加入优先队列进行比较
            if (helper.index<helper.arr.length-1) {
                queue.add(new Helper(helper.arr, helper.index+1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1,3,5,7},{2,4,6},{0,8,9,10,11}};
        Test486 test = new Test486();
        int[] result = test.mergekSortedArrays(arrays);
        for (int i: result) {
            System.out.print(i+" ");
        }
    }
}
