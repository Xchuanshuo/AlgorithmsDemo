package tree.avl;

import java.util.ArrayList;

/**
 * @author Legend
 * @data by on 18-6-24.
 * @description AVL树
 */
public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key)<0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key)>0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        // 更新Height
        node.height = 1+Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor)>1) {
            System.out.println("unbalanced: "+balanceFactor);
        }
        // 平衡维护
        //　LL
        if (balanceFactor>1 && getBalanceFactor(node.left)>=0) {
            return rightRotate(node);
        }
        //RR
        if (balanceFactor<-1 && getBalanceFactor(node.right)<=0) {
            return leftRotate(node);
        }
        // LR
        if (balanceFactor>1 && getBalanceFactor(node.left)<0) {
            node.left = leftRotate(node);
            return rightRotate(node);
        }
        // RL
        if (balanceFactor<-1 && getBalanceFactor(node.right)>0) {
            node.right = rightRotate(node);
            return leftRotate(node);
        }

        return node;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key)==0) {
            return node;
        } else if (key.compareTo(node.key)<0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        Node retNode;
        if (key.compareTo(node.key)<0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key)>0) {
            node.right = remove(node.right, key);
            retNode =  node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                Node successor = miniMum(node.right);
                successor.left = node.left;
                successor.right = remove(node.right, successor.key);
                node.left = node.right = null;
                retNode = successor;
            }
        }
        if (retNode == null) return null;
        retNode.height = Math.max(getHeight(retNode.left), getHeight(retNode.right))+1;
        int balanceFactor = getBalanceFactor(retNode);

        // LL
        if (balanceFactor>1 && getBalanceFactor(retNode.left)<=0) {
            return rightRotate(retNode);
        }

        // RR
        if (balanceFactor<-1 && getBalanceFactor(retNode.right)>=0) {
            return leftRotate(retNode);
        }
        // LR
        if (balanceFactor>1 && getBalanceFactor(retNode.left)>0) {
            retNode.left = leftRotate(retNode);
            return rightRotate(retNode);
        }

        // RL
        if (balanceFactor<-1 && getBalanceFactor(retNode.right)<0) {
            retNode.right = rightRotate(retNode);
            return leftRotate(retNode);
        }
        return retNode;
    }

    private Node miniMum(Node node) {
        if (node.left == null) {
            return node;
        }
        return miniMum(node.left);
    }
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null?null: node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key+" doesn't exits!");
        }
        node.value = newValue;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //　获取节点的高度
    private int getHeight(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    //　获得节点node的平衡因子
    private int getBalanceFactor(Node node) {
        if (node == null) return 0;
        return getHeight(node.left)-getHeight(node.right);
    }

    //　右旋转 返回旋转后的根节点
    private Node rightRotate(Node node) {
        Node x = node.left;
        Node temp = x.right;

        // 向右旋转过程
        x.right = node;
        node.left = temp;

        // 更新height
        node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;
        return x;
    }

    //　左旋转 返回旋转后的根节点
    private Node leftRotate(Node node) {
        Node x = node.right;
        Node temp = x.left;

        // 向左旋转过程
        x.left = node;
        node.right = temp;

        // 更新height
        node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;

        return x;
    }

    // 判断二叉树是否是一颗平衡二叉树
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) return true;
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor>1) return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    // 判断二叉树是否是一颗二叉搜索树
    public boolean inBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i=1;i<keys.size();i++) {
            if (keys.get(i-1).compareTo(keys.get(i))>0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) return;
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }
}
