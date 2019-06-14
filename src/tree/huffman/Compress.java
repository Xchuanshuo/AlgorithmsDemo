package tree.huffman;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * @author Legend
 * @data by on 19-5-6.
 * @description
 */
public class Compress {

    private static final int R = 256;
    private String filePath;
    private String fileName;
    private String absPath;
    private String compressedStr = "";
    private String treeStr = "";

    public Compress(String filePath) throws IOException {
        this.filePath = filePath;
        File tempFile = new File(filePath);
        this.fileName = tempFile.getName();
        this.absPath = tempFile.getParentFile().getCanonicalFile()+"/";
    }

    // 压缩
    public void compress() {
        String str = new String(FileUtil.getBytesByFile(filePath));
        char[] input = str.toCharArray();
        // 统计每个字符的频率
        int[] freq = new int[65555];
        for (int i = 0;i < input.length;i++) {
            freq[input[i]]++;
        }
        // 构建Huffman树
        Node root = buildTrie(freq);
        // 构建查找表
        String[] st = new String[65555];
        buildCode(st, root, "");
        // 生成字典树
//        writeTrie(root);
        // 映射表
        Map<String, Character> charMap = new HashMap<>();
        // 输出未压缩时的长度
        System.out.println(input.length * 2);
        // 合并字符对应的Huffman编码        System.out.println(treeStr);

        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < input.length;i++) {
            String code = st[input[i]];
            if (code == null) continue;
            builder.append(code);
            if (!charMap.containsKey(code)) {
                charMap.put(code, input[i]);
            }
//            System.out.print(input[i] + ": ");
//            for (int j = 0;j < code.length();j++) {
//                if (code.charAt(j) == '0') {
//                    System.out.print(0);
//                } else if (code.charAt(j) == '1') {
//                    System.out.print(1);
//                } else {
//                    throw new IllegalStateException("Illegal state");
//                }
//            }
//            System.out.println();
        }
        String mapStr = JSON.toJSONString(charMap);
        System.out.println(mapStr);
        compressedStr = builder.toString();
        System.out.println(compressedStr);

        // 压缩 1.元数据包括文件名(64字节)
        //     2.单词查找树长度(32字节)
        //     3.单词查找树字符串
        //     4.补的位数(1字节) 5.编码后的串
        byte[] fileNameBytes = ByteUtil.getFileNameBytes(fileName);
        byte[] treeStrBytes = mapStr.getBytes();
        System.out.println(treeStr);
        byte[] treeStrLenBytes = ByteUtil.getTreeLengthBytes(treeStrBytes.length);
        byte[] reminderByte = new byte[]{ByteUtil.getReminder(compressedStr)};
        byte[] compressedStrBytes = ByteUtil.binStrToBytes(compressedStr);
        // 合并全部的字节数组
        byte[] result = ByteUtil.combineBytes(fileNameBytes, treeStrLenBytes, treeStrBytes, reminderByte, compressedStrBytes);

        FileUtil.writeFile(absPath+fileName.split("\\.")[0]+".hf", result);
        System.out.println("压缩成功~~~");
    }

    // 构造Huffman树
    private Node buildTrie(int[] freq) {
        Queue<Node> pq = new PriorityQueue<>();
        for (char i = 0;i < R;i++) {
            if (freq[i] > 0) {
                pq.offer(new Node(i, freq[i], null, null));
            }
        }
        if (pq.size() == 1) {
            if (freq['\0'] == 0) pq.offer(new Node('\0', 0, null, null));
            else pq.offer(new Node('\1', 0, null, null));
        }
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0',left.freq + right.freq, left, right);
            pq.offer(parent);
        }
        return pq.poll();
    }

    // 把树变为字符串
    private void writeTrie(Node x) {
        if (x.isLeaf()) {
            treeStr += '1';
            treeStr += x.ch;
            return;
        }
        treeStr += '0';
        writeTrie(x.left);
        writeTrie(x.right);
    }

    // 构建查找表
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left, s + '0');
            buildCode(st, x.right, s + '1');
        } else {
            st[x.ch] = s;
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "/home/legend/Projects/IdeaProjects/AlgorithmsDemo/pride-and-prejudice.txt";
        Compress compress = new Compress(path);
        compress.compress();
    }
}
