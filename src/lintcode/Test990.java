package lintcode;

/**
 * @author Legend
 * @data by on 18-9-29.
 * @description beautiful-arrangement
 * idea:
 *      dfs + 回溯
 */
public class Test990 {

    private int count = 0;
    public int countArrangement(int N) {
        // Write your code here
        boolean[] visited = new boolean[N+1];
        dfs(1, N, visited);
        return count;
    }

    private void dfs(int pos, int n, boolean[] visited) {
        if (pos > n) {
            count++;
        }
        for (int i=1;i<=n;i++) {
            if (!visited[i] && (i%pos==0 || pos%i==0)) {
                visited[i] = true;
                dfs(pos+1, n, visited);
                visited[i] = false;
            }
        }
    }
}
