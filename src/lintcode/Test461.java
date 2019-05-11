package lintcode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 19-5-11.
 * @description kth-smallest-numbers-in-unsorted-array
 */
public class Test461 {

    public int kthSmallest(int k, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return quickSelect(nums, 0, nums.length - 1, k-1);
    }

    public int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[l];
        int pivot = nums[(l+r)/2];
        int i = l, j = r;
        while (i <= j) {
            while (i <= j && nums[i] < pivot) i++;
            while (i <= j && nums[j] > pivot) j--;
            if (i <= j) swap(nums, i++, j--);
        }
        if (k <= j && l <= j) {
            return quickSelect(nums, l, j, k);
        } else if (k >= i && i <= r) {
            return quickSelect(nums, i, r, k);
        } else {
            return nums[k];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        Test461 test = new Test461();
        FileInputStream fis = new FileInputStream("/home/legend/文档/5.in");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        int k = Integer.parseInt(reader.readLine());
        System.out.println(k);
        String str = reader.readLine();
        str = str.replace("[", "").replace("]","");
        String[] strings = str.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : strings) {
            list.add(Integer.valueOf(s));
        }
        //Collections.sort(list);
        System.out.println(list.size());
        int[] nums = new int[list.size()];
        for (int i = 0;i < nums.length;i++) {
            nums[i] = list.get(i);
        }
        int result = test.kthSmallest(k , nums);
        System.out.println(result);
    }
}
