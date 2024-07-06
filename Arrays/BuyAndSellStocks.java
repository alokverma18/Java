import java.util.Scanner;

public class BuyAndSellStocks {

    public static int maxProfit(int price[]){
        int maxProfit = 0;
        int minBuy = price[0];

        for (int i = 0; i < price.length; i++) {
            maxProfit = Math.max(price[i]-minBuy, maxProfit);
            minBuy = Math.min(minBuy, price[i]);
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Days : ");
        int n = sc.nextInt();

        int price[] = new int[n];

        System.out.print("Enter the Prices : ");
        for (int i = 0; i < price.length; i++) {
            price[i] = sc.nextInt();
        }

        System.out.println("Max Profit : " + maxProfit(price));

        sc.close();
    }
    
}
