public class Solution812 {

    public static void main(String[] args) {
        System.out.println(largestTriangleArea(new int[][]{{4, 6}, {6, 5}, {3, 1}}));
    }

    public static double largestTriangleArea(int[][] points) {
//        定义len为参数points的长度，定义result为结果
        int len = points.length;
        double result = 0;

//        三重for循环来遍历三个点，调用area方法获取当前遍历到的三个点组成三角形的面积
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
//                    调用Math.max方法，将面积最大值更新到result中
                    result = Math.max(result, area(points[i], points[j], points[k]));
                }
            }
        }
        return result;
    }

//    当三个点A、B、C的坐标分别为A(x1，y1)、B(x2，y2)、C(x3、y3)时，三角形面积为，S=(x1y2-x1y3+x2y3-x2y1+x3y1-x2y2) / 2
    public static double area(int[] p1, int[] p2, int[] p3) {
        return Math.abs(p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1] -p1[1] * p2[0] - p2[1] * p3[0] - p3[1] * p1[0]) * 0.5;
    }
}
