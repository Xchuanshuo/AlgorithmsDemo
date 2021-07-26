package leetcode.twolcp52;

/**
 * @author Legend
 * @data by on 21-5-15.
 * @description
 */
public class Test5744 {

    public char[][] rotateTheBox(char[][] Box) {
        int m = Box.length, n = Box[0].length;
        char[][] box = new char[n][m];
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                box[j][m-i-1] = Box[i][j];
            }
        }
        for (int i = n - 2;i >= 0;i--) {
            for (int j = 0;j < m;j++) {
                if (box[i][j] == '#' && box[i+1][j] == '.') {
                    int t = i+1;
                    while (t < n && box[t][j] == '.') {
                        t++;
                    }
                    box[t-1][j] = '#';
                    box[i][j] = '.';
                }
            }
        }
        return box;
    }
}
