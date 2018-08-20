package lintcode;

/**
 * @author Legend
 * @data by on 18-8-20.
 * @description android-unlock-pattern
 * idea:
 *      dfs+回溯 这到题算是比较trick的了 因为需要思考清楚安卓解锁的规则是怎样的
 *      两个位置中间不能空一个位置 所以可以用一个表来保存这个规则 如skip[1][3]=2
 *      保存跳过的数 如果是skip[1][2] 值为0 就说明没跳过任何数 是可以直接滑过去的
 *      后面遍历的时候就好做过滤了 这里还需要用一个数组visited[i]保存被访问过的数i
 *      这样一来条件就出来了 如果当前位置没有被访问过 并且当前位置是可访问的(没跳过任何数或者
 *      中间的那个数被访问过)就可以继续向后操作 当m..n步走完后 就说明这一次滑动方案完成了
 *      对于九宫格来说 手势的规则 从1 3 7 9或者2 4 6 8开始它们的手势方案都是一样的 只是
 *      方向不同 所以 只需要求一个数 然后乘4就是所有的方案 然后对于从5开始的手势是唯一的
 *      最后把这些整合起来 就是全部的结果 最后还需要注意 每次遍历到一个位置时会把它的位置
 *      标记为已经访问 在以这个位置开始的手势结束后需要进行回溯 把它标记为未访问状态 防止其它
 *      的方案遍历到这个位置时无法继续进行下去
 */
public class Test909 {

    public int numberOfPatterns(int m, int n) {
        // Write your code here
        if (m>n || m<0 || n>9) return 0;
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5;
        boolean[] visited = new boolean[10];
        int result = 0;
        for (int i=m;i<=n;i++) {
            result += dfs(visited, skip, 1, i-1)*4;
            result += dfs(visited, skip, 2, i-1)*4;
            result += dfs(visited, skip, 5, i-1);
        }
        return result;
    }

    private int dfs(boolean[] visited, int[][] skip, int cur, int count) {
        if (count==0) return 1;
        visited[cur] = true;
        int result = 0;
        for (int i=1;i<=9;i++) {
            if (!visited[i] && (skip[cur][i]==0 || visited[skip[cur][i]])) {
                result += dfs(visited, skip, i, count-1);
            }
        }
        visited[cur] = false;
        return result;
    }
}
