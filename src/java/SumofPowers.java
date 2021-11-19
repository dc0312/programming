public class SumofPowers {
    public static void main(String[] args) {
        System.out.println(power(2));
    }

    public static Integer power(Integer number) {
        if (number == 0) {
            return 1;
        } else {
            return (1 << number) + power(number - 1);
        }
    }
}
