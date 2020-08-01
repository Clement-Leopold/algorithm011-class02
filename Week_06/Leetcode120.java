import java.util.List;

public class Leetcode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = n - 2; i > -1; i--) {
            List<Integer> line = triangle.get(i);
            List<Integer> linePlusOne = triangle.get(i + 1);
            for (int j = 0; j < line.size(); j++) {
                line.set(j, Math.min(linePlusOne.get(j), linePlusOne.get(j + 1)) + line.get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
