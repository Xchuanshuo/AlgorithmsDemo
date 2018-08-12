package graph.algorithm;

import graph.base.Edge;
import graph.base.WeightGraph;

/**
 * 多源最短路径
 *
 * @author Legend
 * @create 2018-05-23 下午7:38
 **/

public class FloydSP<Weight extends Number & Comparable > {

    private WeightGraph G;
    private int s;
    private Number distTo[][];
    private Edge<Weight> from[][];

    public FloydSP(WeightGraph g, int s) {

        this.G = g;
        this.s = s;
        from = new Edge[G.V()][G.V()];
        for (int i=0;i < G.V();i++) {
            for (int j=0;j < G.V();j++) {
                distTo[i][j] = Double.MAX_VALUE;
            }
            from[i] = null;
        }
        distTo[s][s] = 0.0;
        from[s][s] = new Edge<>(s, s, (Weight)(Number) 0.0);

        // 加入的节点
        for (int k=0;k < G.V();k++) {
            // 起点
            for (int j=0;j < G.V();j++) {
                // 终点
                for (int i=0;i < G.V();i++) {
                    if (distTo[j][i].doubleValue() > distTo[j][k].doubleValue() + distTo[j][i].doubleValue()) {

                    }
                }
            }
        }
    }

}
