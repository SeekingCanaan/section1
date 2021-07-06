import java.util.HashSet;
import java.util.Set;

// 593.有效的正方形
public class Solution593 {

    public static void main(String[] args) {
        System.out.println(validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{1, 1}));
    }

    /**
     * 根据题目条件知
     * 计算出的距离只有两种值，一种是边，一种是对角线
     */
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 定义一个集合，来保存线段长度的数量，如果是2，则返回true；
        Set<Integer> setLine = new HashSet<>();

        // 将四个点放到一个二维数组中
        int[][] points = new int[][]{p1, p2, p3, p4};

        // 循环遍历四个点组成线段的所有距离
        for (int i = 0; i < 3; i++) {
            for (int j = i+1; j < 4; j++) {
                int line = (int)(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                // 如果有线段长度为0，则有重复点，返回false
                if (line == 0) return false;
                // 将计算到的线段长度添加到集合setLine中
                setLine.add(line);
            }
        }
        // 如果setLine长度为2，返回true，否则返回false
        return setLine.size() == 2;
    }

    // 返回两点距离的平方
    public static int getLine(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
}
