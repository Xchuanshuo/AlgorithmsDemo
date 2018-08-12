package unionfind;

/**
 * @author Legend
 * @data by on 18-7-30.
 * @description 并查集接口
 */
public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
