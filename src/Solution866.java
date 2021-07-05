// 866.回文素数
public class Solution866 {

    public static void main(String[] args) {
        System.out.println(primePalindrome(9989900));
    }

    public static int primePalindrome(int n) {
        if (n == 1) return 2;
        // 定义result保存结果
        int result;
        // 定义primeFlag来作为素数标记，palindromeFlag来作为回文数标记
        boolean primeFlag, palindromeFlag;

        // 从 n+1开始循环，如果两个标记都为true，则返回该数
        for (int i = n; ; i++) {
            primeFlag = isPrime(i);
            palindromeFlag = isPalindrome(i);
            if (primeFlag && palindromeFlag) {
                result = i;
                break;
            }
        }
        return result;
    }

    // 判断素数
    public static boolean isPrime(int n) {
        // 定义一个标记flag来判断n是否是素数
        boolean flag = true;

        // 判断素数的方法
        if (n == 2) return true;
        else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
    }

    // 判断回文数
    public static boolean isPalindrome(int n) {
        // 定义一个标记flag来判断n是否是回文数
        boolean flag = true;
        // 将数字 n 转换为字符串 NumToString
        String NumToString = String.valueOf(n);

        // 通过for循环，从两边进行判断对应位置的上的数是否相同。如果有不同，则不是回文数，将flag赋值为false
        for (int left = 0, right = NumToString.length() - 1; left <= right; left++, right--) {
            if (NumToString.charAt(left) != NumToString.charAt(right)) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
