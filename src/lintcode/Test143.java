package lintcode;

/**
 * @author Legend
 * @data by on 18-12-22.
 * @description sort-colors-ii
 * idea:
 *       分治
 */
public class Test143 {

    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors==null || colors.length==0) return;
        sort(colors, 0, colors.length-1, 1, k);
    }

    private void sort(int[] colors, int start, int end, int from, int to) {
        if (start>=end || from >= to) return;
        int p = from + (to-from)/2;
        int j = start;
        for (int i=start;i<=end;i++) {
            if(colors[i] <= p) {
                swap(colors, i, j++);
            }
        }
        sort(colors, start, j-1, from, p);
        sort(colors, j, end, p+1, to);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
