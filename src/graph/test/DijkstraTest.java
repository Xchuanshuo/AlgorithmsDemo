package graph.test;

import graph.algorithm.DijkstraSP;
import graph.base.ReadWeightedGraph;
import graph.base.SparseWeightedGraph;

/**
 * @author Legend
 * @create 2018-05-19 下午12:21
 **/

public class DijkstraTest {


    public static void main(String[] args) {
        String fileName = "/home/legend/Projects/IdeaProjects/AlgorithmsDemo/src/graph/tinyEWG.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, true);
        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(g, fileName);

        System.out.println("lintcode.Test Dijkstra");
        DijkstraSP<Integer> dijkstraTest = new DijkstraSP<>(g, 0);
        for (int i=1;i < V;i++) {
            if (dijkstraTest.hasPathTo(i)) {
                System.out.println("Shortest Path to "+i+" : "+dijkstraTest.shortestPathTo(i));
                dijkstraTest.showPath(i);
            } else {
                System.out.println("No Path to "+i);
            }
            System.out.println("----------------------------------------------------");
        }
    }
}
