package Greedy;

import java.util.Arrays;

public class MinCoinsChange {

    public static int minCoins(int[] coins, int amount){
        Arrays.sort(coins);
        int count = 0;
        int n = coins.length-1;

        while(amount>0){
            count+=amount/coins[n];
            amount%=coins[n];
            n--;
        }
        return count;
    }
    public static void main(String[] args) {
        int amount = 1059;
        int coins[] = new int[] {2, 5, 1, 10, 20, 50, 100, 500, 2000};
        
        System.out.println(minCoins(coins, amount));

    }
}

// not the best always, amount=6, coins=[1, 3, 4]