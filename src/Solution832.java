import java.util.Arrays;

// 832.翻转图像
public class Solution832 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(arr);
    }


    public static int[][] flipAndInvertImage(int[][] image) {

        // 通过for循环将image中的元素通过定义的reverseArr方法，先逆序翻转
        for (int i = 0; i < image.length; i++) {
            image[i] = reverseArr(image[i]);
        }

        // 把image中的每一个元素 0 1 互换
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
        }

        return image;
    }


    // 翻转数组元素
    public static int[] reverseArr(int[] arr) {

        // startIndex 标记数组开头，endIndex 标记数组结尾。定义一个temp来进行值的互换。
        for (int startIndex = 0, endIndex = arr.length - 1; startIndex < endIndex; startIndex++, endIndex--) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
        }
        return arr;
    }
}
