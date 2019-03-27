package lintcode;

/**
 * @author Legend
 * @data by on 19-3-26.
 * @description implement-three-stacks-by-single-array
 */
public class Test224 {

    class ThreeStacks {

        private int[] container;
        private int[] index;
        private int size;

        public ThreeStacks(int size) {
            container = new int[size*3];
            index = new int[3];
            index[1] = size;
            index[2] = 2*size;
            this.size = size;
        }

        public void push(int stackNum, int value) {
            container[index[stackNum]++] = value;
        }

        public int pop(int stackNum) {
            return container[--index[stackNum]];
        }

        public int peek(int stackNum) {
            return container[index[stackNum]-1];
        }

        public boolean isEmpty(int stackNum) {
            return index[stackNum] == stackNum*size;
        }
    }
}
