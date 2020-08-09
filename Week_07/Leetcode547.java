// 朋友圈
public class Leetcode547 {

    public int findCircleNum(int[][] M) {
        int count = 0;
        int N = M.length;
        int[] unionFind = new int[N];
        for (int i = 0; i < N; i++) {
            unionFind[i] = i;
            count++;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (M[i][j] == 1) {
                    count = union(unionFind, i, j, count);
                }
            }
        }
        return count;
    }

    private int find(int p, int[] union) {
        while (union[p] != p) {
            union[p] = union[union[p]];
            p = union[p];
        }
        return p;
    }

    private int union(int[] unionFind, int m, int n, int count) {
        int um = find(m, unionFind);
        int un = find(n, unionFind);
        if (um == un) return count;
        else unionFind[um] = un;
        count--;
        return count;
    }
}
