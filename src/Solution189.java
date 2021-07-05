import java.util.Arrays;

// 189.旋转数组
public class Solution189 {

    public static void main(String[] args) {
        System.out.println();
    }

    public static void rotate(int[] nums, int k) {

//        获取参数数组nums的长度
        int len = nums.length;
//        定义旋转后的数组，长度为nums的长度
        int[] rotateNums = new int[len];

        for (int i = 0; i < len; i++) {
//            通过(i+k)对len取模，进行赋值
//            例如：
//              i = 0, k = 3. len = 7，取模后为3，即rotateNums[3] = nums[0]，向后移动3位
//              i = 5, k = 3. len = 7，取模后为1，即rotateNums[1] = nums[5]，向后移动1位后，达到末尾，再从头开始移动2位
            rotateNums[(i+k) % len] = nums[i];
        }

        System.arraycopy(rotateNums, 0, nums, 0, len);
    }
}
