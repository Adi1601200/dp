package Done;

import java.util.Arrays;

public class BuySellStock2Tab {
    public int maxProfit(int[] prices) {
        int end = prices.length+1;
        int[][] dp = new int[end][2];
        dp[end-1][0] = 0;
        dp[end-1][1] = 0;
        return profit(prices,dp);
    }

    int profit(int[] prices,int[][] dp){
        for(int i = prices.length-1;i>=0;i--){
            for(int j =0;j<=1;j++){
                int ans = 0;
                if(j == 0){
                    ans = Math.max(-prices[i] + dp[i+1][1],dp[i+1][0]);
                }else{
                    ans = Math.max(prices[i] + dp[i+1][0],dp[i+1][1]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }
}
