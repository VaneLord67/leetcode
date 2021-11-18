package offer39;

/**
 * @author CJR
 * @create 2021-11-18-18:02
 */

//摩尔投票法
    //时间复杂度N，空间复杂度1
public class BestSolution {
    public int majorityElement(int [] nums) {
        int x = 0;
        int votes = 0;
        for(int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
