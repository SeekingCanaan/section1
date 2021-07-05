// 704.二分查找
public class Solution704 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 11));
    }

    public static int search(int[] nums, int target) {
//        定义left为左下标，初始值设为0，
//        right为右下标，初始值设为num.length - 1
        int left = 0, right = nums.length - 1;

        while (left <= right) {
//            定义一个mid为中间值下标
            int mid = (left + right) / 2;
//            如果中间值等于要查找的数target，返回下标mid
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
//                如果中间值小于target，则更新左下标left值为mid+1，舍掉从中间下标开始往左所有的数
                left = mid + 1;
            } else if (nums[mid] > target) {
//                如果中间值大于target，则更新右下标right值为mid-1，舍掉从中间下标开始往右所有的数
                right = mid - 1;
            }
        }
        return -1;
    }
}
