// 223.矩形面积
public class Solution223 {
    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0,3, 4, 0, -1, 9, 2));
        System.out.println(computeArea(-2, -2,2, 2, -2, -2, 2, 2));
        System.out.println(computeArea(-2, -2,2, 2, 3, 3, 4, 4));
    }

    /**
     *
     * @param ax1 矩形1左下顶点横坐标
     * @param ay1 矩形1左下顶点纵坐标
     * @param ax2 矩形1右上顶点横坐标
     * @param ay2 矩形1右上顶点纵坐标
     * @param bx1 矩形2左下顶点横坐标
     * @param by1 矩形2左下顶点纵坐标
     * @param bx2 矩形2右上顶点横坐标
     * @param by2 矩形2右上顶点纵坐标
     * @return 两个矩形覆盖的总面积
     */
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        // 矩形1的面积
        int s1 = (ax2 - ax1) * (ay2 - ay1);
        // 矩形2的面积
        int s2 = (bx2 - bx1) * (by2 - by1);

        /**
         *  无重叠
         *  ay1 >= by2 矩形1在矩形2上边
         *  ax2 <= bx1 矩形1在矩形2左边
         *  ay2 <= by1 矩形1在矩形2下边
         *  ax1 >= bx2 矩形1在矩形2右边
         */
        if (ay1 >= by2 || ax2 <= bx1 || ay2 <= by1 || ax1 >= bx2) {
            return s1 + s2;
        } else { // 有重叠
            // 上边界，取两个矩形的上边界的最小值
            int upY = Math.min(ay2, by2);
            // 下边界，取两个矩形的下边界的最大值
            int downY = Math.max(ay1, by1);
            // 左边界，取两个矩形的左边界的最大值
            int rightX = Math.min(ax2, bx2);
            // 右边界，取两个矩形的右边界的最小值
            int leftX = Math.max(ax1, bx1);

            // 返回两个矩形面积和 - 重叠面积 即为 两个矩形覆盖总面积
            return s1 + s2 - (upY - downY) * (rightX - leftX);
        }
    }
}
