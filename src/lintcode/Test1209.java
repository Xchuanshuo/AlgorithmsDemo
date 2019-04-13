package lintcode;

/**
 * @author Legend
 * @data by on 19-4-13.
 * @description construct-the-rectangle
 */
public class Test1209 {

    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) w--;
        return new int[]{area/w, w};
    }
}
