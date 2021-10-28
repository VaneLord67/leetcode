package offer09;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author CJR
 * @create 2021-10-27-16:59
 */
class CQueue {
    Deque<Integer> stack1 = new LinkedList<>();
    Deque<Integer> stack2 = new LinkedList<>();

    public CQueue() {
    }


    public void appendTail(int value) {
        stack1.push(value);

/*
 * 当有新元素时
 * 1. 将s1压入s2
 * 2. 将新元素压入s2
 * 3. 将s2压入s1
 */
//        while(!stack1.isEmpty()){
//            stack2.push(stack1.pop());
//        }
//        stack2.push(value);
//        while(!stack2.isEmpty()){
//            stack1.push(stack2.pop());
//        }
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            return -1;
        }
        return stack2.pop();
//        if(stack1.isEmpty()){
//            return -1;
//        }
//        return stack1.pop();
    }
}