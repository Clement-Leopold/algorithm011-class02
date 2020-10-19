package leetcode;

import java.util.LinkedList;

public class Leetcode977 {

    public int[] sortedSquares(int[] A) {
        LinkedList<Integer> negativeSquare = new LinkedList<>();
        LinkedList<Integer> positiveSquare = new LinkedList<>();
        int[] res = new int[A.length];
        for (int a : A) {
            if (a < 0) negativeSquare.addFirst(a * a);
            if (a >= 0) positiveSquare.addLast(a * a);
        }
        int i1 = 0, i2 = 0, index = 0;
        while (i1 < negativeSquare.size() || i2 < positiveSquare.size()) {
            if (i1 < negativeSquare.size() && i2 < positiveSquare.size()) {
                res[index++] = negativeSquare.get(i1) < positiveSquare.get(i2) ? negativeSquare.get(i1++) : positiveSquare.get(i2++);
            }
            else if (i1 < negativeSquare.size()) res[index++] = negativeSquare.get(i1++);
            else if (i2 < positiveSquare.size()) res[index++] = positiveSquare.get(i2++);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-3,0,2};
        Leetcode977 leetcode977 = new Leetcode977();
        leetcode977.sortedSquares(input);
    }
}

