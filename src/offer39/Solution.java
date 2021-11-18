package offer39;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author CJR
 * @create 2021-11-18-17:43
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x,1);
            } else {
                map.put(x,map.get(x) + 1);
            }
        }
        int[] ints = map.entrySet().stream().filter(x -> x.getValue() > (nums.length / 2)).mapToInt(Map.Entry::getKey).toArray();
        return ints[0];
    }
}
