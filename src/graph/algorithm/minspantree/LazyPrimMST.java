package graph.algorithm.minspantree;

import graph.base.Edge;
import graph.base.WeightGraph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

/**
 * @author Legend
 * @data by on 18-12-2.
 * @description 使用Prim算法求图的最小生成树
 */
public class LazyPrimMST<Weight extends Number & Comparable> {

    // 图的引用
    private WeightGraph<Weight> G;
    // 最小堆(优先队列) 算法辅助数据结构
    private Queue<Edge<Weight>> pq;
    // 标记算法运行过程中结点是否被访问
    private boolean[] marked;
    // 最小生成树所包含的所有边
    private Vector<Edge<Weight>> mst;
    // 最小生成树的权值
    private Number mstWeight = 0;

    public LazyPrimMST(WeightGraph<Weight> graph) {
        G = graph;
        pq = new PriorityQueue<>();
        marked = new boolean[G.V()];
        mst = new Vector<>();

        visit(0);
        while (!pq.isEmpty()) {
            // 找出已经访问的边中全值最小的边
            Edge<Weight> e = pq.poll();
            // 如果这一条边的两端都已经访问过了 则扔掉这条边
            if (marked[e.v()] == marked[e.w()]) {
                continue;
            }
            // 将这条边加入最小生成树
            mst.add(e);
            if (!marked[e.v()]) {
                visit(e.v());
            } else {
                visit(e.w());
            }
        }
        // 计算最小生成树的权值
        for (int i=0;i<mst.size();i++) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }
    }

    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;

        // 将和结点v相连接的所有未访问的边放入最小堆中
        for (Edge<Weight> e: G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.offer(e);
            }
        }
    }

    // 访问最小生成树的所有边
    public Vector<Edge<Weight>> getMst() {
        return mst;
    }

    // 返回最小生成树的权值
    public Number result() {
        return mstWeight;
    }
}
