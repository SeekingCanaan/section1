import java.util.ArrayList;
import java.util.List;

// 728.自除数
public class Solution728 {

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        // 定义list保存结果
        List<Integer> list = new ArrayList<>();

        // 从左边界开始循环
        for (int i = left; i <= right; i++) {
            // 定义 useI 为当前用到的i;
            int useI = i;
            // 定义 flag 标记来判断当前循环到的数 i 是否为自除数
            boolean flag = true;
            // 通过while循环来遍历，每一次将 useI 除以 10 ，直到为 0 退出循环
            while (useI > 0) {
                // 定义 digit 为当前循环到的位数上的数
                int digit = useI % 10;
                // 如果digit为 0，则这个数不是自除数，直接让flag=false，跳出while循环
                if (digit == 0) {
                    flag = false;
                    break;
                } else {  // 如果digit不为0，则判断 i % digit == 0
                    flag = i % digit == 0;
                }
                // 让useI 缩小 10 倍
                useI = useI / 10;
                // 如果flag为false了，跳出while循环
                if (!flag) break;
            }
            // 如果 flag 仍为 true，则 i 为自除数，将 i 添加到列表list中
            if (flag)
                list.add(i);
        }
        return list;
    }
}
