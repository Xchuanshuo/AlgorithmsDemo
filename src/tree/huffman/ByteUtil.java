package tree.huffman;

import java.nio.ByteBuffer;

/**
 * @author Legend
 * @data by on 19-5-7.
 * @description
 */
public class ByteUtil {

    public static final int FILE_NAME_SIZE = 64;
    public static final int TREE_LENGTH_SIZE = 32;
    public static final int TREE_CODE_START_INDEX = 96;

    public static byte[] binStrToBytes(String binStr) {
        int segment = binStr.length()/7;
        int reminder = getReminder(binStr);
        if (reminder != 0) segment++;
        for (int i = 0;i < reminder;i++) {
            binStr = binStr + '0';
        }
        byte[] bytes = new byte[segment];
        for (int i = 0;i < segment;i++) {
            String temp = binStr.substring(i*7, i*7 + 7);
            bytes[i] = Byte.parseByte(temp, 2);
        }
        return bytes;
    }

    // 记录补齐的位
    public static byte getReminder(String binStr) {
        int t = binStr.length()%7;
        int reminder = t == 0 ? 0 : 7 - t;
        return (byte) reminder;
    }

    public static byte[] combineBytes(byte[]...byteArrays) {
        int len = 0;
        for (int i = 0;i < byteArrays.length;i++) {
            len += byteArrays[i].length;
        }
        byte[] bytes = new byte[len];
        int pre = 0;
        for (int i = 0;i < byteArrays.length;i++) {
            System.arraycopy(byteArrays[i], 0, bytes, pre, byteArrays[i].length);
            pre += byteArrays[i].length;
        }
        return bytes;
    }

    public static byte[] getFileNameBytes(String fileName) {
        byte[] src = fileName.getBytes();
        byte[] bytes = new byte[FILE_NAME_SIZE];
        System.arraycopy(src, 0, bytes, bytes.length-src.length, Math.min(bytes.length, src.length));
        return bytes;
    }

    public static byte[] getTreeLengthBytes(int len) {
        String lenStr = String.valueOf(len);
        byte[] src = lenStr.getBytes();
        byte[] bytes = new byte[TREE_LENGTH_SIZE];
        System.arraycopy(src, 0, bytes, bytes.length-src.length, Math.min(bytes.length, src.length));
        return bytes;
    }

    public static void main(String[] args) {
        String binStr = "1111111111111111";
        byte[] bytes = ByteUtil.binStrToBytes(binStr);
        for (byte b : bytes) {
            System.out.println(b);
        }
    }
}
