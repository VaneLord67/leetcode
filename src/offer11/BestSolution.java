package offer11;

/**
 * @author CJR
 * @create 2021-10-28-23:06
 */


public class BestSolution {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        int pivot;
        while(low < high){
            pivot = low + (high - low) / 2;
            if(numbers[pivot] > numbers[high]){
                low = pivot + 1;
            } else if(numbers[pivot] < numbers[high]){
                high = pivot;
            } else {
                high -=1;
            }
        }
        return numbers[low];
    }
}
