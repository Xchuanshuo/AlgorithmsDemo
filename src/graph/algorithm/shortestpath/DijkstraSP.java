package graph.algorithm.shortestpath;

import graph.base.Edge;
import graph.base.IndexMinHeap;
import graph.base.WeightGraph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.Vector;

/**
 * Djikstra算法求最短路径
 *
 * @author Legend
 * @create 2018-05-19 上午11:41
 **/

public class DijkstraSP<Weight extends Number & Comparable> {

    // 图的引用
    private WeightGraph G;
    // 起始点
    private int s;
    // distTo[i]储存从起始点到i的最短路径的长度
    private Number[] distTo;
    //　标记数组，算法运行过程标记节点i是否被访问
    private boolean[] marked;
    //　from[i]记录最短路径中　到达i点的边是哪一条
    // 可以用来恢复最短路径
    private Edge<Weight>[] from;

    public DijkstraSP(WeightGraph graph, int s) {
        G = graph;
        assert s >= 0 && s < G.V();
        this.s = s;
        distTo = new Number[G.V()];
        marked = new boolean[G.V()];
        from = new Edge[G.V()];
        for (int i=0;i < G.V();i++) {
            distTo[i] = 0.0;
            marked[i] = false;
            from[i] = null;
        }
        // 使用索引堆记录当前找到的到达每个顶点的最短距离
        IndexMinHeap<Weight> minHeap = new IndexMinHeap<>(G.V());

        distTo[s] = 0.0;
        from[s] = new Edge<Weight>(s, s, (Weight)(Number)(0.0));
        minHeap.insert(s, (Weight) distTo[s]);
        marked[s] = true;
        while (!minHeap.isEmpty()) {
            int v = minHeap.extractMinIndex();

            // distTo[v]就是s到v的最短距离
            marked[v] = true;
            // 对v的所有相邻节点进行更新
            for (Object item : G.adj(v)) {
                Edge<Weight> e = (Edge<Weight>) item;
                int w = e.other(v);
                if (!marked[w]) {
                    // 如果w没被访问过　或者通过当前的v点到w点距离更短　则进行更新
                    if (from[w] == null || distTo[v].doubleValue()+e.wt().doubleValue() < distTo[w].doubleValue()) {
                        distTo[w] = distTo[v].doubleValue() + e.wt().doubleValue();
                        from[w] = e;
                        if (minHeap.contain(w)) {
                            minHeap.change(w, (Weight) distTo[w]);
                        } else {
                            minHeap.insert(w, (Weight) distTo[w]);
                        }
                    }
                }
            }
        }
    }

    // 返回从s到ｗ点的最短距离的长度
    public Number shortestPathTo(int w) {
        assert w >= 0 && w < G.V();
        assert hasPathTo(w);
        return distTo[w];
    }

    public boolean hasPathTo(int w) {
        assert w >= 0 && w < G.V();
        return marked[w];
    }

    // 寻找从s到ｗ的最短路径　将整个路径经过的边放在vec中
    public Vector<Edge<Weight>> shortestPath(int w) {
        assert w >= 0 && w < G.V();
        assert hasPathTo(w);

        // 通过from数组逆向查找从s到w的路路径　存放到栈中
        Stack<Edge<Weight>> stack = new Stack<>();
        Edge<Weight> e = from[w];
        while (e.v() != this.s) {
            stack.push(e);
            e = from[e.v()];
        }
        stack.push(e);

        // 从栈中依次取出元素
        Vector<Edge<Weight>> res = new Vector<>();
        while(!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }

    // 打印出s点到ｗ点的路径
    public void showPath(int w) {
        assert w >= 0 && w < G.V();
        assert hasPathTo(w);

        Vector<Edge<Weight>> path = shortestPath(w);
        for (int i=0;i < path.size();i++) {
            System.out.print(path.elementAt(i).v()+" -> ");
            if (i == path.size()-1) {
                System.out.println(path.elementAt(i).w());
            }
        }
    }
}
