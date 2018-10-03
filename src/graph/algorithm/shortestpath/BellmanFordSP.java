package graph.algorithm.shortestpath;

import graph.base.Edge;
import graph.base.WeightGraph;

import java.nio.file.WatchEvent;
import java.util.Stack;
import java.util.Vector;

/**
 * 使用BellmanFord算法求最短路径
 *
 * @author Legend
 * @create 2018-05-19 下午3:51
 **/

public class BellmanFordSP<Weight extends Number & Comparable> {

    private WeightGraph G;
    private int s;
    private Number[] distTo;
    Edge<Weight>[] from;
    // 标记图中是否有负权环
    boolean hasNegativeCycle;

    public BellmanFordSP(WeightGraph graph, int s) {

        G = graph;
        this.s = s;
        distTo = new Number[G.V()];
        from = new Edge[G.V()];
        for (int i = 0; i < G.V(); i++) {
            from[i] = null;
        }
        distTo[s] = 0.0;
        from[s] = new Edge<Weight>(s, s, (Weight) (Number) 0.0);
        for (int pass = 1; pass < G.V(); pass++) {
            // 每次循环中对所有的边进行一遍松弛操作
            // 先遍历所有顶点　然后遍历和顶点相连的所有的边
            for (int i = 0; i < G.V(); i++) {
                for (Object item : G.adj(i)) {
                    Edge<Weight> e = (Edge<Weight>) item;
                    if (from[e.v()] != null &&
                            (from[e.w()] == null || distTo[e.v()].doubleValue() + e.wt().doubleValue() < distTo[e.w()].doubleValue())) {
                        distTo[e.w()] = distTo[e.v()].doubleValue() + e.wt().doubleValue();
                        from[e.w()] = e;
                    }
                }
            }
        }
        hasNegativeCycle = detectNegativeCycle();
    }

    // 返回图中是否有负权环
    public boolean detectNegativeCycle() {
        for (int i = 0; i < G.V(); i++) {
            for (Object item : G.adj(i)) {
                Edge<Weight> e = (Edge<Weight>) item;
                if (from[e.v()] != null && distTo[e.v()].doubleValue() + e.wt().doubleValue() < distTo[e.w()].doubleValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean negativeCycle() {
        return hasNegativeCycle;
    }

    public Number shortestPathTo(int w) {
        assert w >= 0 && w < G.V();
        assert !hasNegativeCycle;
        assert hasPathTo(w);
        return distTo[w];
    }

    public boolean hasPathTo(int w) {
        assert w >= 0 && w < G.V();
        return from[w] != null;
    }

    public Vector<Edge<Weight>> shortestPath(int w) {
        assert w >= 0 && w < G.V() ;
        assert !hasNegativeCycle ;
        assert hasPathTo(w) ;

        Stack<Edge<Weight>> stack = new Stack<>();
        Edge<Weight> e = from[w];
        while(e.v() != this.s) {
            stack.push(e);
            e = from[e.v()];
        }

        Vector<Edge<Weight>> res = new Vector<>();
        while (!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public void showPath(int w) {
        assert( w >= 0 && w < G.V() );
        assert( !hasNegativeCycle );
        assert( hasPathTo(w) );

        Vector<Edge<Weight>> res = shortestPath(w);
        for (int i=0;i < res.size();i++) {
            System.out.print(res.elementAt(i).v()+" -> ");
            if (i == res.size()-1) {
                System.out.println(res.elementAt(i).w());
            }
        }
    }
}
