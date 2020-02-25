package string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 19-12-7.
 * @description AC自动机(多模式串匹配)
 */
public class AC {

    private AcNode root = new AcNode('/');

    private class AcNode {
        public char data;
        public AcNode[] children = new AcNode[26];
        public boolean isWord;
        public int length = -1; // 当isWord为true时 记录模式串长度
        public AcNode fail; // 失败指针

        public AcNode(char data) {
            this.data = data;
        }
    }

    public void insert(char[] text) {
        AcNode p = root;
        for (char aText : text) {
            int idx = aText - 'a';
            if (p.children[idx] == null) {
                AcNode newNode = new AcNode(aText);
                p.children[idx] = newNode;
            }
            p = p.children[idx];
        }
        p.isWord = true;
        p.length = text.length;
    }

    public boolean find(char[] text) {
        AcNode p = root;
        for (char aText : text) {
            int idx = aText - 'a';
            if (p.children[idx] == null) return false;
            p = p.children[idx];
        }
        return p.isWord;
    }

    /**
     * 构建失败指针
     */
    public void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.poll();
            assert p != null;
            for (int i = 0; i < p.children.length; i++) {
                AcNode cur = p.children[i];
                if (cur == null) continue;
                if (p == root) {
                    cur.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children[cur.data - 'a'];
                        if (qc != null) {
                            cur.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        cur.fail = root;
                    }
                }
                queue.offer(cur);
            }
        }
    }

    public void match(char[] text) {
        int n = text.length;
        AcNode p = root;
        for (int i = 0;i < n;i++) {
            int idx = text[i] - 'a';
            while (p.children[idx] == null && p != root) {
                p = p.fail;
            }
            p = p.children[idx];
            if (p == null) p = root;
            AcNode tmp = p;
            while (tmp != root) {
                if (tmp.isWord) {
                    int pos = i - tmp.length + 1;
                    System.out.println("匹配起始下标" + pos + "; 长度" + tmp.length);
                }
                tmp = tmp.fail;
            }
        }
    }

    public static void main(String[] args) {
        AC ac = new AC();
        String[] sensitiveWords = {"sb", "fuck", "shit", "pig", "dick",
                "vagina", "sucker", "trump"};
        for (String word : sensitiveWords) {
            ac.insert(word.toCharArray());
        }
        ac.buildFailurePointer();
        String text = "thetrumpisapig";
        ac.match(text.toCharArray());
    }
}
