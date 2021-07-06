// 665.非递减数列
public class Solution665 {

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
    }

    /**
     *  4，2，3
     * 	-1，4，2，3
     * 	2，3，3，2，4
     * 判断修改那个数字其实跟再前面一个数的大小有关系，
     * 首先如果再前面的数不存在，比如例子1，4前面没有数字了，我们直接修改前面的数字为当前的数字2即可。
     * 而当再前面的数字存在，并且小于当前数时，比如例子2，-1小于2，我们还是需要修改前面的数字4为当前数字2；
     * 如果再前面的数大于当前数，比如例子3，3大于2，我们需要修改当前数2为前面的数3。
     */
    public static boolean checkPossibility(int[] nums) {

        if (nums == null || nums.length <= 1) return true;
        // 定义count存储递减的次数，如果大于等于2，则不能只改变一个数就让整个数列递减，如果小于等于1，则可以。
        int count = 0;

        // 通过for循环，判断出递减个数，
        for (int i = 1; i < nums.length && count < 2; i++) {
            // 如果后面的数大于等于前面的数，则递增，跳到下一次循环
            if (nums[i-1] <= nums[i]) continue;
            // 如果不符合上面if条件，则表明遇到了递减，将count++
            count++;
            // 判断再前面的数和当前数的大小，如果再前面的数大于当前数，则当前数等于前面的数
            if (i - 2 >= 0 && nums[i-2] > nums[i])
                nums[i] = nums[i-1];
            // 如果再前面的数小于等于当前数，前面的数等于当前数
            else nums[i-1] = nums[i];
        }

        // 最后返回 count <= 1
        return count <= 1;
    }
}
