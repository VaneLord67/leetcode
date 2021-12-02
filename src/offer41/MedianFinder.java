package offer41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author CJR
 * @create 2021-11-18-20:01
 */
public class MedianFinder {

    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public Double findMedian() {
        if (list.size() == 0) {
            return null;
        }
        Collections.sort(list);
        if ((list.size() & 1) == 1) {
            return (double) list.get(list.size() / 2);
        } else {
            return (double)(list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2;
        }
    }
}
