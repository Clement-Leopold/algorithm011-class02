package dfs.traceback;

import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k, new ArrayList<>());
        return res;
    }

    private void dfs(int i, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < n + 1; j++) {
            list.add(j);
            dfs(j + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}
