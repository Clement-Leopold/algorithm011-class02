import java.util.ArrayList;
import java.util.List;

public class Leetcode22GenerateParenthesis {

    List<String> ans = new ArrayList<>();
    private static final Character LEFT = '(';
    private static final Character RIGHT = ')';

    public List<String> generateParenthesis(int n) {
        generate(n, 0,0, new StringBuilder());
        return ans;
    }

    private void generate(int n, int left, int right, StringBuilder builder) {
        if (left > n) {
            return;
        }
        if (right > left) {
            return;
        }
        if (left == right && left == n) {
            ans.add(builder.toString());
        }
        builder.append(LEFT);
        generate(n, left + 1, right, builder);
        builder.delete(builder.length() - 1, builder.length());
        builder.append(RIGHT);
        generate(n, left, right + 1, builder);
        builder.delete(builder.length() - 1, builder.length());
    }


    public static void main(String[] args) {
        int n = 3;
        Leetcode22GenerateParenthesis leetcode22GenerateParenthesis = new Leetcode22GenerateParenthesis();
        leetcode22GenerateParenthesis.generateParenthesis(3);
    }
}
