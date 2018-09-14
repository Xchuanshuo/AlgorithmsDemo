package lintcode;

/**
 * @author Legend
 * @data by on 18-9-14.
 * @description remove-element
 * idea:
 *      可以使用双指针
 */
public class Test172 {

    public int removeElement(int[] A, int elem) {
        // write your code here
        int i = 0;
        int pointer = A.length - 1;
        while (i <= pointer) {
            if (A[i] == elem) {
                A[i] = A[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer+1;
    }
}
