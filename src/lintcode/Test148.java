package lintcode;

/**
 * @author Legend
 * @data by on 18-10-1.
 * @description sort-colors
 * idea:
 *      这道题有多种解法 显而易见的就是使用计数排序 不过需要扫描数组3遍
 *      (统计频率、借助辅助数组将元素分类、回写)；不过用另一种方法 可以只需要扫
 *      描数组1遍 使用三个指针 分别为start、current、end 如果当前元素为0 就和
 *      start进行交换;如果为1，就直接把当前的位置往后移;如果为2 就和end进行交换
 *      当start与end两个指针碰撞时 就说明元素的分类已经完成
 */
public class Test148 {

    public void sortColors1(int[] nums) {
        // write your code here
        if (null == nums || nums.length == 0) return;
        int start=0, current=0, end=nums.length-1;
        while (current <= end ) {
            if (nums[current] == 0)  {
                swap(nums, current++, start++);
            } else if (nums[current] == 1) {
                current++;
            } else {
                swap(nums, current, end--);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // 计数排序
    public void sortColors(int[] nums) {
        int[] key = new int[4];
        int[] aux = new int[nums.length];
        // 计算频率
        for (int i=0;i < nums.length;i++) {
            key[nums[i]+1]++;
        }
        // 将频率转换为索引
        for (int i=0;i < 3;i++) {
            key[i+1] += key[i];
        }
        // 将元素分类
        for (int i=0;i < nums.length;i++) {
            aux[key[nums[i]]++] = nums[i];
        }
        nums = aux;
//        // 回写
//        for (int i=0;i < nums.length;i++) {
//            nums[i] = aux[i];
//        }
    }
}
