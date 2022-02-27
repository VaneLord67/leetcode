package offer53_1;

/**
 * @author CJR
 * @create 2022-02-24-0:29
 */
class Solution {

    public int search(int[] nums, int target) {
        int res = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                res++;
                int tmp = mid;
                while (--tmp >= 0) {
                    if (nums[tmp] == target) res++;
                    else break;
                }
                tmp = mid;
                while (++tmp < nums.length) {
                    if (nums[tmp] == target) res++;
                    else break;
                }
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}