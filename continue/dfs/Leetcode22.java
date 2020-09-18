package dfs;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", 0, 0, n * 2, res);
        return res;
    }

    private void dfs(String result, int left, int right, int length, List<String> res) {
        if (result.length() == length) {
            res.add(result);
            return;
        }
        if (left < length / 2) dfs(result + "(", left + 1, right, length, res);
        if (right < left) dfs(result + ")", left, right + 1, length, res);
    }
}
