import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 19-11-13.
 * @description
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0;i < 10;i++) {
            queue.offer(i);
            deque.offer(i);
        }
        for (int i = 0;i < 10;i++) {
            System.out.println("queue: " + queue.poll());
            System.out.println("deque: " + deque.poll());
        }
    }
}
