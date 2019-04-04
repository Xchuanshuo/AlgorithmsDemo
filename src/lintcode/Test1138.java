package lintcode;

/**
 * @author Legend
 * @data by on 19-4-4.
 * @description can-place-flowers
 */
public class Test1138 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Write your code here
        int i = 0;
        while (i < flowerbed.length && n > 0) {
            if (flowerbed[i] == 0 && (i==0 || flowerbed[i-1]==0)
                    && (i==flowerbed.length-1 || flowerbed[i+1] == 0)){
                flowerbed[i] = 1;
                n--;
            }
            i++;
        }
        return n == 0;
    }
}
