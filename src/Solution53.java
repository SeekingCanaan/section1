// 53.最大子序和

public class Solution53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1, 2, 3, -4, -1, -3}));
    }

    public static int maxSubArray(int[] nums) {

        //  定义maxNum作为最大子序列和，先将数组第一个数赋值给maxNum，作为初始值
        //  prev存储当前循环到的序列和最大值，初始值设为0
        int maxNum = nums[0], prev = 0;

        for (int num : nums) {

            //  prev + num 为当前循环到的子序列和，num为当前循环到的值，取二者中的最大值作为当前子序列和的最大值
            prev = Math.max(prev + num, num);

            //  比较当前子序列和最大值prev和maxNum，取二者中的最大值作为要返回的最大子序列和
            maxNum = Math.max(maxNum, prev);
        }
        return maxNum;
    }
}
