package offer19;

/**
 * @author CJR
 * @create 2021-10-30-17:02
 */

/*
剑指 Offer 19. 正则表达式匹配
请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
而'*'表示它前面的字符可以出现任意次（含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 2; i < n + 1; i+=2) {
            dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(p.charAt(j - 1) == '*'){
                    if(dp[i][j-2]) dp[i][j] = true;
                    else if(dp[i-1][j] && s.charAt(i-1) == p.charAt(j - 2)) dp[i][j] = true;
                    else if(dp[i-1][j] && p.charAt(j - 2) == '.') dp[i][j] = true;
                } else {
                    if(dp[i-1][j-1] && s.charAt(i - 1) == p.charAt(j - 1)) dp[i][j] = true;
                    else if(dp[i-1][j-1] && p.charAt(j - 1) == '.') dp[i][j] = true;
                }
            }
        }

        return dp[m][n];
    }
}