package offer21;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CJR
 * @create 2021-11-03-18:29
 */

/*
剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class Solution {
    public int[] exchange(int[] nums) {
        return Arrays.stream(nums).boxed().sorted((o1, o2) -> {
            if ((o1 & 1) == (o2 & 1)) {
                return 0;
            } else if ((o1 & 1) == 1 && (o2 & 1) == 0) {
                return -1;
            } else {
                return 1;
            }
        }).mapToInt(x -> x).toArray();
    }
}
