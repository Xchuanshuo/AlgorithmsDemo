package tree.huffman;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static tree.huffman.ByteUtil.FILE_NAME_SIZE;
import static tree.huffman.ByteUtil.TREE_CODE_START_INDEX;

/**
 * @author Legend
 * @data by on 19-5-7.
 * @description
 */
public class DeCompress {

    private String fileName;
    private String absPath;
    private String treeStr;
    private String compressedStr;
    private byte[] bytes;

    public DeCompress(String filePath) throws IOException {
        File tempFile = new File(filePath);
        absPath = tempFile.getParentFile().getCanonicalFile() + "/";
        // 读取压缩文件
        bytes = FileUtil.getBytesByFile(filePath);
        // 获取原始文件名
        fileName = new String(Arrays.copyOfRange(bytes, 0, FILE_NAME_SIZE)).trim();
        // 读取树的长度
        String treeLenStr = new String(Arrays.copyOfRange(bytes, FILE_NAME_SIZE, TREE_CODE_START_INDEX), "UTF-8");
        int treeLength = Integer.parseInt(treeLenStr.trim());
        // 根据长度读取树字符串
        this.treeStr = new String(Arrays.copyOfRange(bytes, TREE_CODE_START_INDEX, TREE_CODE_START_INDEX+treeLength), "UTF-8");
        System.out.println("读取单词查找树");

        // 真正压缩后数据的读取
        int COMPRESSED_START_INDEX = TREE_CODE_START_INDEX+treeLength+1;
        int COMPRESSED_END_INDEX = bytes.length;
        // 补的位 需要在读取后的串里面去掉
        int reminder = Arrays.copyOfRange(bytes, COMPRESSED_START_INDEX-1, COMPRESSED_START_INDEX)[0];
        // 真正数据
        byte[] compressedBytes = Arrays.copyOfRange(bytes, COMPRESSED_START_INDEX, COMPRESSED_END_INDEX);
        this.compressedStr = getCompressedStr(reminder, compressedBytes);
        System.out.println("读取编码表");
    }

    private String getCompressedStr(int reminder, byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < bytes.length;i++) {
            String str = Integer.toBinaryString(bytes[i]);
            builder.append(getCompleteStr(str));
        }
        return builder.substring(0, builder.length()-reminder);
    }

    public static String getCompleteStr(String code) {
        int len = 7-code.length();
        String temp = "";
        if (len > 0) temp = String.format("%0"+len+"d", 0);
        return len == 0 ? code : temp + code;
    }

    // 解压缩
    public void decompress() {
        System.out.println("开始解压缩....");
        Node root = readTrie();
        List<Byte> byteList = new ArrayList<>();
        while (compressedStr.length() > 0) {
            Node x = root;
            while (!x.isLeaf()) {
                char a = compressedStr.charAt(0);
                compressedStr = compressedStr.substring(1, compressedStr.length());
                if (a == '1') {
                    x = x.right;
                } else {
                    x = x.left;
                }
            }
            byteList.add((byte) x.ch);
        }

        String filePrefix = "de_";
        byte[] result = new byte[byteList.size()];
        for (int i = 0;i < result.length;i++) {
            result[i] = byteList.get(i);
        }
        FileUtil.writeFile(absPath + filePrefix + fileName, result);
        System.out.println("解压缩完成");
    }

    // 重键单词查找树
    private Node readTrie() {
        char a = treeStr.charAt(0);
        treeStr = treeStr.substring(1);
        if (a == '1') {
            char ch = treeStr.charAt(0);
            treeStr = treeStr.substring(1);
            return new Node(ch, 0, null, null);
        }
        return new Node('\0', 0, readTrie(), readTrie());
    }

    public static void main(String[] args) throws IOException {
        String path = "/home/legend/Projects/IdeaProjects/AlgorithmsDemo/src/tree/huffman/abra.txt";
        DeCompress deCompress = new DeCompress(path);
        deCompress.decompress();
    }
}
