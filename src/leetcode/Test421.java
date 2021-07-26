package leetcode;

/**
 * @author Legend
 * @data by on 21-5-16.
 * @description https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * idea:
 *      1.遍历一遍原数组 对每个数构成的二进制位构建出一颗字典树
 *      2.再遍历一遍 对于当前数 去查找字典树 获取当前数可以与其它数构成的最大异或值
 *        基于贪心的思路, 要让异或值最大, 高位就需要尽量为1, 因为0^1=1
 *        所以当前数对应的位数i如果为0, 就去字典树查找为1的子节点; 当前位为1, 就去查找为0的子节点;
 *        找不到则选取另一个节点, 直到到达叶子节点
 */
public class Test421 {

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int n : nums) trie.insert(n);
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, trie.getXor(n));
        }
        return max;
    }

    class Trie {
        Node root;

        public Trie() {
            this.root = new Node(-1);
        }

        public void insert(int word) {
            Node cur = root;
            for (int i = 31;i >= 0;i--) {
                int v = (word >> i)&1;
                if (cur.next[v] == null) {
                    cur.next[v] = new Node(v);
                }
                cur = cur.next[v];
            }
        }

        public int getXor(int word) {
            Node cur = root;
            int res = 0;
            for (int i = 31;i >= 0;i--) {
                int bit = (word>>i)&1;
                int t = 1^bit;
                if (cur.next[t] != null) {
                    cur = cur.next[t];
                } else {
                    cur = cur.next[bit];
                }
                res = res | ((cur.val^bit) << i);
            }
            return res;
        }
    }

    class Node {
        int val = 0;
        Node[] next = new Node[2];
        public Node(int val) {
            this.val = val;
        }
    }
}
