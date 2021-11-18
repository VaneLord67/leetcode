package offer40;

import java.util.Arrays;

/**
 * @author CJR
 * @create 2021-11-18-18:06
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = arr[i];
        }
        return ints;
    }
}
