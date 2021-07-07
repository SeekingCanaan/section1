public class Solution443 {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'}));
    }

    public static int compress(char[] chars) {

        // 定义一个左指针
        int left = 0;

        // 保存最终结果，压缩后的字符数组长度
        int size = 0;

        // 定义右指针作为循环遍历，让right能够取到char.length，计算到最后一个字符
        for (int right = 0; right <= chars.length; right++) {

            if (right == chars.length || chars[right] != chars[left]) {

                // 将该字符先保留到chars中，下面再计算出它的个数，保留到它的后面
                chars[size++] = chars[left];

                // 如果连续相同字符个数大于 1
                if (right - left > 1) {
                    // 则把这个个数值变为字符添加到chars数组中，有可能字符个数大于等于 10 个
                    // 所以先把 right - left 的值先转换为字符数组，在加入到 chars 中
                    for (char c : String.valueOf(right - left).toCharArray()) {
                        chars[size++] = c;
                    }
                }
                // 已经计算完该连续字符的个数，更新 left 的值，指向 right 的值
                left = right;
            }
        }

        return size;
    }
}
