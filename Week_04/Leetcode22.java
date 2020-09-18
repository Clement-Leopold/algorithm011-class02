import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n, "");
        return ans;
    }

    private void dfs(int left, int right, int n, String res) {
        if (res.length() == n * 2) {
            ans.add(res);
        }
        if (left < n) {
            dfs(left + 1, right, n, res + "(");
        }
        if (right < left) {
            dfs(left, right + 1, n, res + ")");
        }
    }
}
