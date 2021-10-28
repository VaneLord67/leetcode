package lc01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author CJR
 * @create 2021-10-27-12:02
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if(map.containsKey(x)){
                return new int[]{i,map.get(x)};
            } else {
                map.put(nums[i],i);
            }
        }

        return new int[]{-1,-1};
    }
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if(nums[i] + nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return new int[]{-1,-1};
//    }
}