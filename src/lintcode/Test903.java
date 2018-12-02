package lintcode;

/**
 * @author Legend
 * @data by on 18-11-1.
 * @description range-addition
 * idea:
 *      sweep line
 *   5  [[1,3,2],[2,4,3],[0,2,-2]] -> [-2,0,3,5,3]
 *   arr[0,2,0,0,-2,0]->[0,2,3,0,-2,-3]->[-2,2,3,2,-2,-3]
 *   res[-2,]
 */
public class Test903 {

    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] arr = new int[length+1];
        for (int[] update: updates) {
            int start = update[0];
            int end = update[1]+1;
            int val = update[2];
            arr[start] += val;
            arr[end] += -1*val;
        }
        int[] result = new int[length];
        result[0] = arr[0];
        for (int i=1;i<length;i++) {
            result[i] = result[i-1] + arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Test903 test903 = new Test903();
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        int[] res = test903.getModifiedArray(5, updates);
        for (int i: res) {
            System.out.print(i+", ");
        }
    }
}
