import java.util.HashMap;

public class Leetcode322CoinChange {

    HashMap<Integer, Integer> coinMap = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int value = coin(coins, amount);
        return value == Integer.MAX_VALUE ? -1 : value;
    }

    private int coin(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (coinMap.get(amount) != null) {
            return coinMap.get(amount);
        }
        if (amount == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coin(coins, amount - coin);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        if (min == Integer.MAX_VALUE) {
            coinMap.put(amount, -1);
        } else {
            coinMap.put(amount, min);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1};
        Leetcode322CoinChange leetcode322CoinChange = new Leetcode322CoinChange();
        System.out.println(leetcode322CoinChange.coinChange(coins, 0));
    }
}
