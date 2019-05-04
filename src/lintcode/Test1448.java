package lintcode;

/**
 * @author Legend
 * @data by on 19-5-3.
 * @description card-game
 */
public class Test1448 {

    private int n, totalProfit, totalCost;
    private int count = 0;
    public int numOfPlan(int n, int totalProfit, int totalCost, int[] a, int[] b) {
        this.n = n;
        this.totalProfit = totalProfit;
        this.totalCost = totalCost;
        dfs(a, b, 0, 0, 0, new boolean[n]);
        return count;
    }

    private void dfs(int[] a, int[] b, int sumA, int sumB, int index, boolean[] visited) {
        if (index >= n) return;
        if (sumA > totalProfit && sumB < totalCost) count++;
        for (int i = index;i < n;i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(a, b, sumA+a[i], sumB+a[i], i, visited);
                visited[i] = false;
            }
        }
    }
}
