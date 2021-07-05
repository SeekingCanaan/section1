// 831.隐藏个人信息
public class Solution831 {
    public static void main(String[] args) {
        System.out.println(maskPII("86-(10)12345678"));
    }

    public static String maskPII(String s) {
        // 字符串里面是否含有@符号，即为邮箱字符串
        int isEmail = s.indexOf('@');
        // 邮箱
        if (isEmail >= 0) {
            // 保留第一个字符和@符号前的一个字符，中间用 ***** 表示，将字母小写
            return (s.substring(0, 1) + "*****" + s.substring(isEmail - 1)).toLowerCase();
        } else { // 电话
            // 保存电话号里面的数字
            String nums = "";
            // 保存格式化后的结果
            String result = "";

            // 找出电话号里的数字
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    nums += s.charAt(i);
                }
            }

            // 本地号格式
            if (nums.length() == 10)
                result += "***-***-" + nums.substring(6);
            else if (nums.length() > 10) {  // 国际号码格式
                // 先加上开头的 + 号
                result += "+";
                // 定义要加上的 * 数量
                int starLen = nums.length() - 10;
                // 循环加 *
                for (int i = 0; i < starLen; i++) {
                    result += "*";
                }
                // 最后再加上固定的 -***-***- 和最后四位数字
                result += "-***-***-" + nums.substring(nums.length() - 4);
            }
            return result;
        }
    }
}
