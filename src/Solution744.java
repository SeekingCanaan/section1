// 寻找比目标字母大的最小字母
public class Solution744 {

    public static void main(String[] args) {
        char[] chs = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        System.out.println(nextGreatestLetter(chs, 'f'));
    }


    public static char nextGreatestLetter(char[] letters, char target) {
        // 遍历letters，如果当前元素大于目标元素target，返回当前元素
        for (char letter : letters) {
            if (letter > target) return letter;
        }
        // 如果最终没有找到比目标元素大的第一个元素，返回数组第一个元素
        return letters[0];
    }
}
