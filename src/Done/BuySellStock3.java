package Done;

import java.util.Arrays;

public class BuySellStock3 {

    public int maxProfit(int[] prices) {
        int end = prices.length-1;
        int[][] dp = new int[end+1][end+1];

        int maxIndex = 0;
        int minIndex = 0;
        int maxProfit = 0;
        int secondMaxProfit = 0;
        for(int i =0;i<end+1;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<prices.length;i++){
            for(int j=i;j<prices.length;j++){
                dp[i][j] = prices[j]-prices[i];
                if(maxProfit<dp[i][j]){
                    maxProfit = dp[i][j];
                    maxIndex = j;
                    minIndex = i;
                }
            }
        }

        return secondMaxProfit+maxProfit;
    }
}
