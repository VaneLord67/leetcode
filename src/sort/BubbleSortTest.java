package sort;

import java.util.Arrays;

/**
 * @author CJR
 * @create 2022-02-27-16:09
 */
public class BubbleSortTest {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 3, 2};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
