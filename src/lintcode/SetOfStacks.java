package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Legend
 * @data by on 18-6-10.
 * @description 第490号题　set-of-stacks
 */
public class SetOfStacks {

    private List<Stack<Integer>> list;
    private int capacity;

    public SetOfStacks(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.list = new ArrayList<>();
    }

    /*
     * @param v: An integer
     * @return: nothing
     */
    public void push(int v) {
        // write your code here
        if (list.isEmpty() || list.get(list.size()-1).size()==capacity) {
            Stack<Integer> stack = new Stack<>();
            stack.add(v);
            list.add(stack);
        } else {
            list.get(list.size()-1).add(v);
        }
    }

    public int pop() {
        // write your code here
        int last = list.size()-1;
        int result = list.get(last).pop();
        if (list.get(last).isEmpty()) {
            list.remove(last);
        }
        return result;
    }

    public static void main(String[] args) {
        String str="q";
    }
}