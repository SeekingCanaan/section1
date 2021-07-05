//  371.两整数之和
public class Solution371 {

    public static void main(String[] args) {
        System.out.println(getSum(5, 3));
    }

//    101  5
//    011  3
    public static int getSum(int a, int b) {
        while (b != 0) {
            int temp = a & b;
            a = a ^ b;
            b = temp << 1;
        }
        return a;
    }
}
