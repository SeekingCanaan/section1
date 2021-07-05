public class Solution485 {


    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        // 定义maxLen存放最长连续个数, preLen存放当前遍历到的最长连续个数
        int maxLen = 0, preLen = 0;
        // 从前到后遍历，如果是1就将maxLen加1，如果是0就将maxLen归0
        for (int num : nums) {
            if (num == 1) {
                preLen++;
                maxLen = Math.max(maxLen, preLen);
            } else {
                preLen = 0;
            }
        }
        return maxLen;
    }
}
