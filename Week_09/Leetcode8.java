import java.math.BigInteger;

public class Leetcode8 {

    public int myAtoi(String str) {
        int symbol = 0;
        int start = 0;
        for (start = 0; start < str.length(); start++) {
            if (symbol == 0 && str.charAt(start) == ' ') continue;
            else if (symbol != 0 && str.charAt(start) == ' ') return 0;
            else if (str.charAt(start) == '+' && symbol == 0) symbol = 1;
            else if (str.charAt(start) == '-' && symbol == 0) symbol = 2;
            else if (str.charAt(start) >= '0' && str.charAt(start) <= '9') break;
            else return 0;
        }
        long number = 0;
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) == ' ') break;
            else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                number = number * 10 + str.charAt(i) - '0';
                if (number > Integer.MAX_VALUE) {
                    break;
                }
            } else break;
        }
        if (symbol == 2) return number >= (long)Integer.MAX_VALUE + 1? Integer.MIN_VALUE : (int) -number;
        else return number > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) number;
    }

    public static void main(String[] args) {
        String s = " +0 123";
        Leetcode8 leetcode8 = new Leetcode8();
        System.out.println(leetcode8.myAtoi(s));
    }


}
