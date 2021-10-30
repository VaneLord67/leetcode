package offer13;

/**
 * @author CJR
 * @create 2021-10-28-23:58
 */

/*
剑指 Offer 13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */


// dfs+剪枝
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().cul(35, 37));
    }


    public int movingCount(int m, int n, int k) {
        boolean[][] isMoved = new boolean[m][n];
        return dfs(0,0,k,m,n,isMoved);
    }

    public int dfs(int i,int j,int k,int m,int n,boolean[][] isMoved){
        if(i < 0 || i > m - 1 || j < 0 || j > n - 1 || cul(i,j) > k || isMoved[i][j]) return 0;
        isMoved[i][j] = true;
        return dfs(i,j+1,k,m,n,isMoved)
        + dfs(i,j-1,k,m,n,isMoved)
        + dfs(i+1,j,k,m,n,isMoved)
        + dfs(i-1,j,k,m,n,isMoved)
                + 1;
//        isMoved[i][j] = false;
    }

    public int cul(Integer o1,Integer o2){
        return culOne(o1) + culOne(o2);
    }

    public int culOne(Integer n){
        int sum = 0;
        while(n >= 10){
            sum += n % 10;
            n /= 10;
        }
        sum += n;
        return sum;
    }

}