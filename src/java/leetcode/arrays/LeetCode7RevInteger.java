package leetcode.arrays;

public class LeetCode7RevInteger {
    public static void main(String[] args) {
        int x = -123;
        System.out.println("Result : " + reverse(x));
    }

    public static int reverse(int x) {
        int c = 0;
        long r = 0;
        while (x != 0) {

            r = (x % 10) + r * 10;
            c = c * 10 + (x % 10);
            x = x / 10;
            if (r > Integer.MAX_VALUE || -1 * r > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return c;

    }
}
