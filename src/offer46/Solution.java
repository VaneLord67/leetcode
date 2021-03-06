package offer46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CJR
 * @create 2022-01-30-22:45
 */
public class Solution {
    public int translateNum(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
