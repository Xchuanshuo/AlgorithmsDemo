package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-6-13.
 * @description
 */
public class Test912 {

    public int minTotalDistance(int[][] grid) {
        // Write your code here
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i=0;i < grid.length;i++) {
            for (int j=0;j < grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Collections.sort(col);
        int res=0, left=0, right=row.size()-1;
        while (left<right) {
            res += row.get(right)-row.get(left) + col.get(right--)-col.get(left++);
        }
        return res;
    }

    public static void main(String[] args) {
        Test912 test = new Test912();
        int[][] grid = {
                {1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}
        };
        System.out.println(test.minTotalDistance(grid));
    }
}
