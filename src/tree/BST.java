package tree;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-6-17.
 * @description
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;
        public Node(E e) {
            this.e = e;
            left = right = null;
        }
    }

    private Node root;
    private int size;
    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }
    // 向以node为根的节点处插入元素
    // 返回插入新结点后的根节点
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e)<0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e)>0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    // 查看二分搜索树中是否包含元素
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 前序遍历非递归实现
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void inOrderNR() {
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            if (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.println(node.e);
                temp = node.right;
            }
        }
    }

    public void postOrderNR() {

    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 后序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 层序遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.e);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    // BST的最小元素
    public E miniMum() {
        if (size == 0) {
            throw new IllegalArgumentException("The BST is Empty !");
        }
        return miniMum(root).e;
    }

    // BST的最大元素
    public E maxiMum() {
        if (size == 0) {
            throw new IllegalArgumentException("The BST IS Empty !");
        }

        return maxiMum(root).e;
    }

    // 删除BST的最小元素 并返回
    public E removeMin() {
        E ret = miniMum();
        root = removeMin(root);
        return ret;
    }

    // 删除BST的最大元素　并返回
    public E removeMax() {
        E ret = maxiMum();
        root = removeMax(root);
        return ret;
    }

    // 删除任意节点
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e)<0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e)>0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                return removeMin(node);
            }
            if (node.right == null) {
                return removeMax(node);
            }
            Node successor = miniMum(node.right);
            successor.left = node.left;
            successor.right = removeMin(node.right);
            node.left = node.right = null;

//            Node successor = maxiMum(node.left);
//            successor.left = removeMax(node.left);
//            successor.right = node.right;
//            node.left = node.right = null;
            return successor;
        }
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private Node miniMum(Node node) {
        if (node.left == null) {
            return node;
        }
        return miniMum(node.left);
    }

    private Node maxiMum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxiMum(node.right);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        generateBSTString(root, 0, result);
        return result.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder result) {
        if (node == null) {
            result.append(generateDepth(depth)+"null\n");
            return;
        }
        result.append(generateDepth(depth)+node.e+"\n");
        generateBSTString(node.left, depth+1, result);
        generateBSTString(node.right, depth+2, result);
    }

    private String generateDepth(int depth) {
        StringBuilder builder = new StringBuilder();
        for (int i=0;i < depth;i++) {
            builder.append("--");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(1);
        bst.add(2);
        bst.add(3);
        bst.add(4);
        bst.add(5);
        bst.levelOrder();
        System.out.println("------------------------------------");
        bst.preOrderNR();
        System.out.println("------------------------------------");
        bst.inOrderNR();
        System.out.println("------------------------------------");
        bst.postOrder();
    }

    /**
     *           1
     *             2
     *               3
     *                 4
     *                   5
     */
}
