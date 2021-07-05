public class Solution744 {

    public static void main(String[] args) {
        char[] chs = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        System.out.println(nextGreatestLetter(chs, 'z'));
    }


    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (letters[mid] == target) {
                return letters[mid];
            } else if (letters[mid] < target) {
                left = mid + 1;
            } else if (letters[mid] > target) {
                right = mid - 1;
            }
        }
        return letters[0];
    }
}
