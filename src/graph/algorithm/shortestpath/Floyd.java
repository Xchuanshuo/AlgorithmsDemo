package graph.algorithm.shortestpath;

/**
 * @author Legend
 * @create 2018-05-23 下午10:01
 * @description 多源最短路径
 **/

public class Floyd {

    private int n, a[][];

    public static void main(String[] args) {
        Floyd floyd = new Floyd();
        floyd.init();
    }

    private void init() {
        n = 5;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.MAX_VALUE >> 1;
            }
            a[i][i] = 0;
        }
        a[0][1] = 10;
        a[1][0] = 10;
        a[0][3] = 30;
        a[3][0] = 30;
        a[0][4] = 100;
        a[4][0] = 100;
        a[1][2] = 50;
        a[2][1] = 50;
        a[2][3] = 20;
        a[3][2] = 20;
        a[2][4] = 10;
        a[4][2] = 10;
        a[3][4] = 60;
        a[4][3] = 60;
        floyd();
    }

    private void floyd() {
        for (int k=0;k < n;k++) {
            for (int i=0;i < n;i++) {
                for (int j=0;j < n;j++) {
                    a[i][j] = Math.min(a[i][j], a[i][k]+a[k][j]);
                }
            }
        }

        for (int i=0;i < n;i++) {
            for (int j=i+1;j < n;j++) {
                System.out.println(i+"->"+j+": "+a[i][j]);
            }
        }
    }
}
