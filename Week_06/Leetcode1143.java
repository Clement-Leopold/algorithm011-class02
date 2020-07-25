public class Leetcode1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // t1 的前i个字符 与t2 的前j个字符的公共最长子序列
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String text1 = "ace";
        String text2 = "abcde";
        Leetcode1143 leetcode1143 = new Leetcode1143();
        leetcode1143.longestCommonSubsequence(text1,text2);
    }
}
