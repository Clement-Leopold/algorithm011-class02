import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 */
public class Leetcode77Combine {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineRecur(1, n, k, new ArrayList<>());
        return ans;
    }

    private void combineRecur(int i, int n, int k, List<Integer> middleValue) {
        if (middleValue.size() == k) {
            ans.add(new ArrayList<>(middleValue));
            return;
        }

        for (int m = i; m <= n; m++) {
            middleValue.add(m);
            combineRecur(m+1, n, k, middleValue);
            middleValue.remove(middleValue.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        Leetcode77Combine leetcode77Combine = new Leetcode77Combine();
        leetcode77Combine.combine(4, 2);
    }
}
