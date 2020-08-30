public class Leetcode771 {

    public int numJewelsInStones(String J, String S) {
        int[] array = new int[256];
        for (int i = 0; i < J.length(); i++) {
            array[J.charAt(i)] = 1;
        }
        int res = 0;
        for (int j = 0; j < S.length(); j++) {
            res = array[S.charAt(j)] == 1 ? res + 1 : res;
        }
        return res;
    }
}
