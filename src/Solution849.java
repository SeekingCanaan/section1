import java.util.Arrays;

// 849.到最近的人的最大距离
public class Solution849 {

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
    }


    public static int maxDistToClosest(int[] seats) {

        /**
         * 定义N为座位长度
         * left数组存放当前座位i到左边人的最近距离
         * right数组存放当前座位i到右边人的最近距离
         */
        int N = seats.length;
        int[] left = new int[N], right = new int[N];
        // 将left, right数组的每个元素都初始化为N
        Arrays.fill(left, N);
        Arrays.fill(right, N);

        // 遍历出坐到座位i 到 左边的人的最近距离
        for (int i = 0; i < N; i++) {
            if (seats[i] == 1) left[i] = 0;
            else if (i > 0) left[i] = left[i-1] + 1;
        }

        // 遍历出坐到座位i 到 右边的人的最近距离
        for (int i = N - 1; i >= 0; i--) {
            if (seats[i] == 1) right[i] = 0;
            else if (i < N - 1) right[i] = right[i+1] + 1;
        }

        // 定义ans保存结果，到最近的人的最大距离
        int ans = 0;
        // 通过遍历整理过的left和right，找出最远距离
        for (int i = 0; i < N; i++) {
            if (seats[i] == 0) {
                // Math.min(left[i], right[i]) 先取出left[i]和right[i]的最小值
                // 取最小值可以保证到离他最近的人左右两边距离最远，如果取最大值，则可能会是到最近人左右两边距离不是最远
                // 然后更新ans，保存这个最远距离
                ans = Math.max(ans, Math.min(left[i], right[i]));
            }
        }
        return ans;
    }
}
