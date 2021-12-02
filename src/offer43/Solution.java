package offer43;

/**
 * @author CJR
 * @create 2021-12-02-19:48
 */

//超出时间限制
public class Solution {
    public static void main(String[] args) {
        new Solution().countDigitOne(824883294);
    }

    public int countDigitOne(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == '1') {
                    cnt++;
                    System.out.println(cnt);
                }
            }
        }
        return cnt;
    }
}