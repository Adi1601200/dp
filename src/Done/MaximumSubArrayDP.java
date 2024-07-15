package Done;

import java.util.concurrent.atomic.AtomicInteger;

public class MaximumSubArrayDP {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = Integer.MIN_VALUE/2;
            }
        }
        AtomicInteger max = new AtomicInteger(nums[0]);
        int ans = calculateMaxArray(0,nums.length-1,nums,max,dp);
        return Math.max(ans, max.get());
    }

    private int calculateMaxArray(int start, int end, int[] nums, AtomicInteger max, int[][] dp) {
        if (start >= nums.length || end < 0) {
            return Integer.MIN_VALUE / 2;
        }
        if(dp[start][end]!=Integer.MIN_VALUE/2){
            return dp[start][end];
        }
        if(start == end){
            if(max.get()<nums[start]){
                max.set(nums[start]);
            }
            dp[start][start] = nums[start];
            return nums[start];
        }
        dp[start][end-1] = calculateMaxArray(start,end-1,nums, max, dp);
        dp[start+1][end] =  calculateMaxArray(start+1,end,nums, max, dp);
        if(dp[start][end-1]>dp[start+1][end]){
            if(max.get()<dp[start][end-1]){
                max.set(dp[start][end-1]);
            }
        }else{
            if(max.get()<dp[start+1][end]){
                max.set(dp[start+1][end]);
            }
        }
        dp[start][end] = nums[start] + dp[start+1][end];
        return nums[start] + dp[start+1][end];
    }
}
