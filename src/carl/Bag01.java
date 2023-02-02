package carl;

import java.util.Arrays;

/**
 * @author CJR
 * @create 2022-12-19-16:38
 */
public class Bag01 {

    public static void main(String[] args) {
        new Bag01().Solution();
    }

    public void Solution() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        //
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
