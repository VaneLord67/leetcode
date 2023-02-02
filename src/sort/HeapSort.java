package sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author CJR
 * @create 2022-03-06-17:07
 */

/**
 * 最大堆的实现以及堆排序（排序后数组元素从小到大）
 * 如果只需要二叉堆的排序，我们只调用构建二叉堆和下沉方法即可。
 * 上浮方法是插入的时候调用的。先在堆的末尾新增节点，并让新增的节点上浮。
 */
public class HeapSort {
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;       // 左孩子
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;       // 如果 右孩子存在 且 右孩子值更大，那么就选择右孩子来进行比较
            }
            if (temp >= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void heapSort(int[] array) {
        // 通过孩子节点获取父节点是 parentIdx = (childIdx - 1) / 2
        // 这里是array,length - 1 - 1
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length); // 构建二叉堆：让所有非叶子节点依次下沉，从最后一个非叶子节点开始。
        }
//        System.out.println(Arrays.toString(array));
        for (int i = array.length - 1; i > 0; i--) {    // 交换堆顶和堆的最后一个元素，并让新的堆顶下沉
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
//        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
//            downAdjust(arr, i, arr.length); // 构建二叉堆：让所有非叶子节点依次下沉，从最后一个非叶子节点开始。
//        }
//        arr[9] = 11;
//        upAdjust(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
