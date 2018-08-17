package lintcode;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description sliding-puzzle-iii
 * idea:
 *      与sliding-puzzle-i 和 ii做法一样
 *      除了这个方法 还有一种数学方法 就是判断一个排列的逆序数的和是否为偶数
 *      为偶数则说明这个排列可以恢复到最开始的状态
 */
public class Test950 {

    public String jigsawPuzzle(int[][] matrix) {
        // Write your code here
        if (matrix==null || matrix.length==0) return "YES";
        int[] array = new int[8];
        int k = 0;
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (matrix[i][j] !=0 ) array[k++] = matrix[i][j];
            }
        }
        int count = 0;
        for (int i=0;i<8;i++) {
            for (int j=i+1;j<8;j++) {
                if (array[i]>array[j]) count++;
            }
        }
        return (count&1)==0?"YES":"NO";
    }

    public static void main(String[] args) {
        System.out.println(9&1);
    }
}
