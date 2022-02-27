package offer57_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CJR
 * @create 2022-02-26-1:38
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < target; i++) {
            List<Integer> tmp = new ArrayList<>();
            int sum = i;
            tmp.add(i);
            for (int j = i + 1; sum < target; j++) {
                sum += j;
                tmp.add(j);
            }
            if (sum == target) {
                res.add(tmp);
            }
        }
        int[][] intRes = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            Integer[] integers = list.toArray(new Integer[0]);
            intRes[i] = Arrays.stream(integers).mapToInt(x -> x).toArray();
        }
        return intRes;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().findContinuousSequence(9)));
    }
}