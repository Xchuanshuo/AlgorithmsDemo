package graph.test;

import graph.algorithm.BaseQueueBFSP;
import graph.algorithm.BellmanFordSP;
import graph.base.ReadWeightedGraph;
import graph.base.SparseWeightedGraph;

/**
 * @author Legend
 * @create 2018-05-19 下午4:22
 * @description largetEWG.txt这个测试文件太大, 188M 不方便上传了
 *              可以去网上查找《算法》相关的测试文件
 **/

public class BellmanFordTest {

    public static void main(String[] args) {

        String fileName = "/home/legend/Projects/IdeaProjects/AlgorithmsDemo/src/graph/largeEWG.txt";
        int V = 1000000;
        long start = System.currentTimeMillis();
        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, true);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, fileName);

        System.out.println("lintcode.Test Bellman-Ford:\n");
//        BellmanFordSP<Integer> bellmanFord = new BellmanFordSP<Integer>(g,0);
        // 基于队列的Bellman-Ford算法
        BaseQueueBFSP<Integer> bellmanFord = new BaseQueueBFSP<>(g,0);
        if( bellmanFord.negativeCycle() )
            System.out.println("The graph contain negative cycle!");
        else{

            for( int i = 1 ; i < V ; i ++ ){
                if(bellmanFord.hasPathTo(i)) {
                    System.out.println("Shortest Path to " + i + " : " + bellmanFord.shortestPathTo(i));
                    bellmanFord.showPath(i);
                }
                else
                    System.out.println("No Path to " + i );

                System.out.println("-------------------------");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("The program runs for "+(end-start)+"ms");
    }
}
