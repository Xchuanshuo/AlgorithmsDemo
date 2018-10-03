package graph.base;

import java.util.Vector;

/**
 * 加权有向图
 *
 * @author Legend
 * @create 2018-05-19 上午8:02
 **/

public class EdgeWeightDigraph {

    // 顶点总数
    private final int V;
    //　边总数
    private int E;
    // 邻接表
    private Vector<DirectedEdge> adj;

    public EdgeWeightDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Vector<>();
    }
}
