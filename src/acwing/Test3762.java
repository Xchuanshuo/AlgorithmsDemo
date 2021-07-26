package acwing;

import lintcode.TreeNode;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Legend
 * @data by on 21-7-9.
 * @description https://www.acwing.com/problem/content/3765/
 */
public class Test3762 {

    private static void solve(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int k = 0;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (grid[i][j] == '1') k += 3;
            }
        }
        System.out.println(k);
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                int x = i + 1, y = j + 1;
                if (grid[i][j] == '1') {
                    if (i < m - 1 && j < n - 1) {
                        print(x, y, 1); print(x + 1, y, 0); print(x, y + 1, 2);
                    } else if (i != m - 1 && j == n - 1) {
                        print(x, y, 2); print(x + 1, y, 3); print(x, y - 1, 1);
                    } else if (j != n-1 && i == m - 1) {
                        print(x, y, 0); print(x - 1, y, 1); print(x, y + 1, 3);
                    } else {
                        print(x, y, 3); print(x-1, y, 2); print(x, y - 1, 0);
                    }
                 }
            }
        }
    }

    private static void print(int i, int j, int k) {
        if (k == 0) {
            String str = String.format("%d %d %d %d %d %d", i, j, i-1, j, i, j+1);
            System.out.println(str);
        } else if (k == 1) {
            String str = String.format("%d %d %d %d %d %d", i, j, i+1, j, i, j+1);
            System.out.println(str);
        } else if (k == 2) {
            String str = String.format("%d %d %d %d %d %d", i, j, i+1, j, i, j-1);
            System.out.println(str);
        } else {
            String str = String.format("%d %d %d %d %d %d", i, j, i, j-1, i-1, j);
            System.out.println(str);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = Integer.parseInt(scanner.nextLine());
            for (int k = 0;k < t;k++) {
                String[] strs = scanner.nextLine().split(" ");
                int m = Integer.parseInt(strs[0]), n = Integer.parseInt(strs[1]);
                char[][] grid = new char[m][n];
                for (int i = 0;i < m;i++) {
                    grid[i] = scanner.nextLine().toCharArray();
                }
                solve(grid);
            }
        }
    }
}
