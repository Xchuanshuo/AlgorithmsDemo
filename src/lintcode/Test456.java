package lintcode;

/**
 * @author Legend
 * @data by on 19-4-21.
 * @description reference
 */
public class Test456 {

    class ReferenceManager {
        public Node node;

        public void copyValue(Node obj) {
            // copy value from obj to node
            if (node == null) {
                node = new Node(obj.val);
            } else {
                node.val = obj.val;
            }
        }

        public void copyReference(Node obj) {
            // copy reference from obj to node
            this.node = obj;
        }
    }

    class Node {
        public int val;
        public Node(int val) {
            this.val = val;
        }
    }

}
