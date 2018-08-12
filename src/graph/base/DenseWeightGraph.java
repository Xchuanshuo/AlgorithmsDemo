package graph.base;

import java.util.Vector;

/**
 * 稠密图　－　邻接矩阵
 *
 * @author Legend
 * @create 2018-05-19 上午8:37
 **/

public class DenseWeightGraph<Weight extends Number & Comparable> implements WeightGraph<Weight> {

    // 节点数
    private int n;
    // 边数
    private int m;
    // 是否为有向图
    private boolean directed;
    // 图的具体数据
    private Edge<Weight>[][] g;

    public DenseWeightGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        //　初始状态下表示没有任何边
        g = new Edge[n][n];
        for (int i=0;i < n;i++) {
            for (int j=0;j < n;j++) {
                g[i][j] = null;
            }
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge<Weight> e) {
        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;

        if (hasEdge(e.v(), e.w())) {
            return;
        }
        g[e.v()][e.w()] = new Edge(e);
        if (e.v() != e.w() && !directed) {
            g[e.w()][e.v()] = new Edge(e.w(), e.v(), e.wt());
        }
        m++;
    }

    // 验证图只能中是否有从v到w的边
    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w] != null;
    }

    // 显示图的信息
    @Override
    public void show() {
        for (int i=0;i < n;i++){
            for (int j=0;j < n;j++) {
                if (g[i][j] != null) {
                    System.out.print(g[i][j].wt()+"\t");
                } else {
                    System.out.print("NULL\t");
                }
            }
            System.out.println();
        }
    }

    // 返回图中一个顶点所有的边
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Edge<Weight>> adjV = new Vector<>();
        for (int i=0;i < n;i++) {
            if (g[v][i] != null) {
                adjV.add(g[v][i]);
            }
        }
        return adjV;
    }
}
