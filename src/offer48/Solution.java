package offer48;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CJR
 * @create 2022-02-01-17:23
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = -1;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (map.containsKey(tmp)) {
                start = Math.max(start, map.get(tmp));
            }
            map.put(tmp, i);

            max = Math.max(max, i - start);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
    }
}
