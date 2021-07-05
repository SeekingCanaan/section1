import java.util.HashMap;
import java.util.Map;

//  387.字符串中的第一个唯一字符
public class Solution387 {

    public static void main(String[] args) {

        System.out.println(firstUniqChar("loveleetcode"));
    }
    public static int firstUniqChar(String s) {
        // 定义一个hashmap来存放字符和对应的个数
        Map<Character, Integer> charCounts = new HashMap<>();

        // 第一个for循环来存放字符并计算相应个数
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charCounts.put(ch, charCounts.getOrDefault(ch, 0) + 1);
        }

        // 第二个for循环来找到第一个个数为1的字符
        // 通过从字符串开头开始判断，对应的个数是否为1，如果是则返回下标
        for (int i = 0; i < s.length(); i++) {
            if (charCounts.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
