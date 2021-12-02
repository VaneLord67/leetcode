package offer41;

import java.util.*;

/**
 * @author CJR
 * @create 2021-12-02-19:34
 */

//双堆
public class BestSolution {
    Queue<Integer> A,B;
    //A是小顶堆（堆顶是数据结构中最小的元素），保存较大的部分 B是大顶堆(堆顶是数据结构中最大的元素)，保存较小的部分
    //保证A.size() = B.size() + 1 或者A.size() = B.size()

    public BestSolution() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((x, y) -> y - x);
    }


    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public Double findMedian() {
        if (A.size() != B.size()) {
            return (double) A.peek();
        } else {
            return (A.peek() + B.peek()) / 2.0;
        }
    }
}
