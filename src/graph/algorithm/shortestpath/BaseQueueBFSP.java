package graph.algorithm.shortestpath;

import graph.base.Edge;
import graph.base.WeightGraph;

import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 基于队列的BellmanFord算法
 *
 * @author Legend
 * @create 2018-05-19 下午5:39
 **/

public class BaseQueueBFSP<Weight extends Number & Comparable> {


    private WeightGraph G;
    private int s;
    private Number[] distTo;
    Edge<Weight>[] from;
    // 标记图中是否有负权环
    boolean hasNegativeCycle;
    private Queue<Integer> queue;
    private boolean[] isOnQueue;

    public BaseQueueBFSP(WeightGraph graph, int s) {

        G = graph;
        this.s = s;
        distTo = new Number[G.V()];
        isOnQueue = new boolean[G.V()];
        from = new Edge[G.V()];
        queue = new LinkedBlockingQueue<>();
        queue.add(s);
        isOnQueue[s] = true;
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Double.MAX_VALUE;
        }

        distTo[s] = 0.0;
        while (!queue.isEmpty() && !hasNegativeCycle) {
            int v = queue.poll();
            isOnQueue[v] = true;
            for (Object item : G.adj(v)) {
                Edge<Weight> edge = (Edge<Weight>) item;
                int w = edge.other(v);
                if (distTo[w].doubleValue() > distTo[v].doubleValue() + edge.wt().doubleValue()) {
                    distTo[w] = distTo[v].doubleValue() + edge.wt().doubleValue();
                    from[edge.w()] = edge;
                }
                if (!isOnQueue[w]) {
                    queue.add(w);
                    isOnQueue[w] = true;
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
