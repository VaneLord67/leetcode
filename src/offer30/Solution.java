package offer30;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author CJR
 * @create 2021-11-05-15:50
 */

class MinStack {

    Deque<Integer> list;
    Deque<Integer> minList;

    /** initialize your data structure here. */
    public MinStack() {
        list = new LinkedList<>();
        minList = new LinkedList<>();
    }

    public void push(int x) {
        list.push(x);
        if (minList.size() == 0 || x <= minList.peek()) {
            minList.push(x);
        }
    }

    public void pop() {
        if (list.pop().equals(minList.peek())) {
            minList.pop();
        }
    }

    public int top() {
        return list.peek();
    }

    public int min() {
        return minList.peek();
    }
}

