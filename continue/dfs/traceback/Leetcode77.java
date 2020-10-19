package dfs.traceback;

import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(new ArrayList<>(), 1, n, k);
        return res;
    }

    private void dfs(List<Integer> aux, int i, int n, int k) {
        if (aux.size() == k) res.add(new ArrayList<>(aux));
        else {
            for (int j = i; j <= n; j++) {
                aux.add(j);
                dfs(aux, j + 1, n, k);
                aux.remove(aux.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        Leetcode77 leetcode77 = new Leetcode77();
        List<List<Integer>> res = leetcode77.combine(4,2);
        System.out.println();
    }

}
