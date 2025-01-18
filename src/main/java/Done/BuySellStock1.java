package Done;

import java.util.Arrays;

public class BuySellStock1 {



    public int maxProfit(int[] prices) {

        int[] dp = new int[prices.length];
        return profit(prices,dp);

    }

    private int profit(int[] prices, int[] dp) {
        dp[prices.length-1] = prices[prices.length-1];
        for(int i = prices.length-2;i>=0;i--){
            dp[i] = Math.max(prices[i],dp[i+1]);
        }

        for(int i = 0;i<prices.length;i++){
            dp[i] = dp[i] - prices[i];
        }
        return Arrays.stream(dp).max().getAsInt();
    }


}
