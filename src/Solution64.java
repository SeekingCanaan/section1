// 64.最小路径和
public class Solution64 {

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1}, {1,5,1}, {4,2,1}}));
    }

    public static int minPathSum(int[][] grid) {

        // 如果 gird 为 null 或者 grid长度为0，或者grid[0]的长度为0，即没有了起点，返回0
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        // 定义rows为grid长度，即行数；cols为grid[0]的长度，即列数
        int rows = grid.length, cols = grid[0].length;

        // 定义二维数组dp保存结果
        int[][] dp = new int[rows][cols];
        // 将dp[0][0]设置为grid[0][0]，即刚开始要计算原点上的数字
        dp[0][0] = grid[0][0];

        // 将dp的第一列计算出来，由该位置上方的值 + grid在该点的值
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // 将dp的第一行计算出来，由该位置左方的值 + grid在该点的值
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        // 从dp[1][1]开始计算，dp该点的值为该点上方的值和左边的值中的最小值 + grid在该点的值
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }

        // 最后路径和最小就保存在dp[rows-1][cols-1]中
        return dp[rows-1][cols-1];
    }
}
