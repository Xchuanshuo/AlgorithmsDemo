package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-8-14.
 * @description previous-permutation
 * idea:
 *      与next-permutation(Test51)类似 以 1 2 2 4 1-->1 2 2 1 4为例
 *      不过这里是从后向前寻找降序的位置 显然这里是4找到后 再从4这个位置向右
 *      寻找比当前数小的最大值 两者交换位置 这里就直接得到了1 2 2 1 4
 *      如果没有直接得到 就需要把找到的位置后面的数进行翻转 最后得出结果
 *      注：同理 查找位置时没有找到 就说明当前是第一个排列 直接将数组逆序
 *          就得出了它的上一个排列 即最后一个排列
 */
public class Test51 {

    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        if (nums==null || nums.size()==0) return new ArrayList<>();
        int n = nums.size();
        int pos = n - 2;
        while(pos>=0 && nums.get(pos)<nums.get(pos+1)) { pos--; }
        if (pos<0) {
            Collections.reverse(nums);
            return nums;
        }
        int i = n - 1;
        while (nums.get(pos)<nums.get(i)) { i--; }
        swap(nums, i, pos);
        while (pos+1 < n) { swap(nums, ++pos, --n); }
        return nums;
    }

    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    public static void main(String[] args) {
        Test51 test = new Test51();
        List<Integer> list = new ArrayList<>();
        int[] arr = {1, 2, 2, 4, 1};
        for (int i: arr) list.add(i);
        System.out.println(test.previousPermuation(list));
    }
}
