// 883.三维形体投影面积
public class Solution883 {

    public static void main(String[] args) {

    }

    public int projectionArea(int[][] grid) {
        // areas保存三个面阴影的面积之和，len保存gird的长度
        int areas = 0, len = grid.length;

        for (int i = 0; i < len; i++) {
            // maxRow 保存每一行最大值，即侧面阴影
            // maxCol 保存每一列最大值，即正面阴影
            int maxRow = 0, maxCol = 0;
            for (int j = 0; j < len; j++) {
                // 计算顶部阴影面积，如果该位置有立方体，则面积加1
                if (grid[i][j] > 0) areas++;
                // 计算出第i行最大值
                maxRow = Math.max(maxRow, grid[i][j]);
                // 计算出第i列最大值
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            areas += maxRow + maxCol;
        }

        return areas;
    }
}
