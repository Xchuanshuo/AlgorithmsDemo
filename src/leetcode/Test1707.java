package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-23.
 * @description https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array/
 * idea:
 *      1.将nums数组排序, 将quires数组按m从小到大排序, 每次查询时只需要放入小于
 *        等于当前m的数字即可, 字典树不存在小于等于当前的数字，则本次查询结果为-1
 *      2.构造一颗基于nums每个数二进制的字典树
 *      3.对于每个查询, 去计算最大异或值, 即在二进制字典树中从高位到低位,
 *      尽量找与目标数x的二进制位相反的bit位节点, 这样能使结果最大
 */
public class Test1707 {

    public int[] maximizeXor(int[] nums, int[][] Queries) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] queries = new int[Queries.length][3];
        for (int i = 0;i < queries.length;i++) {
            queries[i][0] = Queries[i][0];
            queries[i][1] = Queries[i][1];
            queries[i][2] = i;
        }
        Arrays.sort(queries, (o1, o2) -> o1[1] - o2[1]);
        int idx = 0;
        Trie trie = new Trie();
        int[] res = new int[queries.length];
        for (int i = 0;i < queries.length;i++) {
            int[] q = queries[i];
            int val = q[0], m = q[1], pos = q[2];
            while (idx < n && nums[idx] <= m) {
                trie.insert(nums[idx++]);
            }
            if (idx == 0) {
                res[pos] = -1;
            } else {
                res[pos] = trie.getXor(val);
            }
        }
        return res;
    }

    class Trie {
        Node root = new Node();

        public void insert(int val) {
            Node cur = root;
            for (int i = 31;i >= 0;i--) {
                int bit = (val >>  i) & 1;
                Node[] ch = cur.children;
                if (ch[bit] == null) {
                    ch[bit] = new Node();
                }
                cur = ch[bit];
            }
        }

        public int getXor(int val) {
            Node cur = root;
            int ans = 0;
            for (int i = 31;i >= 0;i--) {
                int bit = (val >> i) & 1;
                Node[] ch = cur.children;
                if (ch[bit^1] != null) {
                    ans |= 1 << i;
                    bit ^= 1;
                }
                cur = ch[bit];
            }
            return ans;
        }
    }

    class  Node {
        Node[] children = new Node[2];
    }
}
