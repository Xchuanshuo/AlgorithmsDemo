package tree.huffman;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Legend
 * @data by on 19-5-7.
 * @description
 */
public class FileUtil {

    public static byte[] getBytesByFile(String path) {
        Path mPath = Paths.get(path);
        byte[] data = new byte[0];
        try {
            data = Files.readAllBytes(mPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void writeFile(String path, byte[] bytes) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
