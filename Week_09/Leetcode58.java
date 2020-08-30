public class Leetcode58 {

    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (count == 0 && s.charAt(i) == ' ') {
                continue;
            } else if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }
}
