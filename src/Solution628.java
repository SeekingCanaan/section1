import java.util.Arrays;

// 三个数的最大乘积
public class Solution628 {

    public static void main(String[] args) {
        int[] arr = {-1, -2, -3};
        System.out.println(maximumProduct(arr));
    }

    public static int maximumProduct(int[] nums) {
        // 先升序排序
        Arrays.sort(nums);

        int n = nums.length;
        // 如果数组中有正有负，那么最大值可能是最后三个数的乘积，也可能是前两个负数和最后正数的乘积，取二者最大值
        return Math.max(nums[0] * nums[1] * nums[n-1], nums[n-3] * nums[n-2] * nums[n-1]);
    }
}
