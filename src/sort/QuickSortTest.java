package sort;

import java.util.Arrays;

/**
 * @author CJR
 * @create 2022-02-27-15:43
 */
public class QuickSortTest {

    public static void quickSort(int[] arr, int startIndex,int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pos = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pos - 1);
        quickSort(arr, pos + 1, endIndex);
    }

    public static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = startIndex;
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while(left < right && arr[right] > arr[pivot]) {
                right--;
            }
            while(left < right && arr[left] <= arr[pivot]) {
                left++;
            }
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        int tmp = arr[left];
        arr[left] = arr[pivot];
        arr[pivot] = tmp;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 2, 3};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
