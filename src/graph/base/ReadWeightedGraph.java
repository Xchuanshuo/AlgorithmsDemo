package graph.base;

import jdk.nashorn.api.tree.ForInLoopTree;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 通过文件读取有权图的信息
 *
 * @author Legend
 * @create 2018-05-19 上午9:53
 **/

public class ReadWeightedGraph {

    private Scanner scanner;

    public ReadWeightedGraph(WeightGraph<Double> graph, String fileName) {
        readFile(fileName);

        try {
            int V = scanner.nextInt();
            if (V < 0) {
                throw new IllegalArgumentException("number of vertices in a Graph must be no negative");
            }
            assert V == graph.V();

            int E = scanner.nextInt();
            if (E < 0) {
                throw new IllegalArgumentException("number of edges in a Graph must be no negative");
            }

            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                Double weight = scanner.nextDouble();
                assert v >= 0 && v < V;
                assert w >= 0 && w < V;
                graph.addEdge(new Edge<Double>(v, w, weight));
            }
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from input stream, but there are no more tokens available");
        }
    }
    private void readFile(String fileName ) {
        assert fileName != null;
        try {
            File file = new File(fileName);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else {
                throw new IllegalArgumentException(fileName+ " doesn't exist.");
            }

        } catch (IOException e) {
            throw new IllegalArgumentException("Could not open "+fileName, e);
        }
    }
}
