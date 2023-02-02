package sort;

import java.util.Arrays;

/**
 * @author CJR
 * @create 2022-03-14-13:26
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 2, 4, 6};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int leftIdx = start;
        int rightIdx = mid + 1;
        int[] res = new int[end - start + 1];
        int resIdx = 0;
        while (leftIdx <= mid && rightIdx <= end) {
            if (nums[leftIdx] <= nums[rightIdx]) {
                res[resIdx++] = nums[leftIdx];
                leftIdx++;
            } else {
                res[resIdx++] = nums[rightIdx];
                rightIdx++;
            }
        }
        while (leftIdx <= mid) {
            res[resIdx++] = nums[leftIdx];
            leftIdx++;
        }
        while (rightIdx <= end) {
            res[resIdx++] = nums[rightIdx];
            rightIdx++;
        }
        for (int i = 0; i < res.length; i++) {
            nums[i + start] = res[i];
        }
    }
}
