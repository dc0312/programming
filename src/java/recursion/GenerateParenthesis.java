package recursion;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 2;
        generateParenthesis(n);
    }

    private static void generateParenthesis(int n) {
        int o = 0, c = 0;
        String op = "(";
        generateParenthesis(op, o + 1, c, n);
    }

    private static void generateParenthesis(String op, int o, int c, int n) {
        if (op.length() == 2 * n) {
            System.out.println(op);
            return;
        }

        if (o < n) {
            generateParenthesis(op + "(", o + 1, c, n);
        }
        if (c < o) {
            generateParenthesis(op + ")", o, c + 1, n);
        }
    }
}
