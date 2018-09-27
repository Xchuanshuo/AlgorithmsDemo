package lintcode;

/**
 * @author Legend
 * @data by on 18-9-28.
 * @description can-reach-the-endpoint
 * idea:
 *      bfs
 */
public class Test1479 {

    public boolean reachEndpoint(int[][] map) {
        // Write your code here
        return helper(map, 0, 0);
    }

    private boolean helper(int[][] map, int x, int y) {
        if (x==map.length || y==map[0].length) {
            return false;
        }
        if (map[x][y] == 9) {
            return true;
        } else if (map[x][y] == 0){
            return false;
        }
        return helper(map, x+1, y) || helper(map, x, y+1);
    }
}
