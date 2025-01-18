package Done;

import java.util.Arrays;

public class BuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        int end = prices.length-1;
        int[][] dp = new int[end+1][2];
        for(int i =0;i<end+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return profit(0,0,prices,dp);
    }

    int profit (int i, int buy , int[] prices, int[][] dp){
        if(i == prices.length){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        int ans = 0;
        if(buy == 0){
            ans = Math.max(-prices[i] + profit(i+1,1,prices, dp),profit(i+1,0,prices, dp));
        }else{
            ans = Math.max(prices[i] + profit(i+1,0,prices, dp),profit(i+1,1,prices, dp));
        }
        dp[i][buy] = ans;
        return ans;
    }


}
