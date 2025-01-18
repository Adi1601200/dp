package Done;

import java.util.Arrays;

public class MinSizeSubArrayInfiniteArray {

    public int minSizeSubarrayV2(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int repetitions = (target / totalSum) + 2;
        int extendedLength = n * repetitions;
        int lastIndex = 0;
        int startIndex = 0;
        int currentSum = 0;
        int ans = Integer.MAX_VALUE;
        while(lastIndex<extendedLength && startIndex<=lastIndex){

            if(currentSum == target){
                ans = Math.min(extendedLength-startIndex,ans);
                currentSum = currentSum + nums[lastIndex%nums.length];
                lastIndex = lastIndex + 1;
            }
            if(currentSum > target){
                currentSum = currentSum - nums[startIndex%nums.length];
                startIndex = startIndex + 1;
            }
            if(currentSum < target){
                currentSum = currentSum + nums[lastIndex%nums.length];
                lastIndex = lastIndex + 1;
            }
        }


        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int minSizeSubarray(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length*2;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        int index1 = 0;
        int index2 = 0;
        if(target>nums.length){
            int factor = (int) Math.ceil((target)/ sum);
            end = nums.length * (factor+2);
        }
        int[][] dp = new int[end+1][end+1];
        for(int i = 0;i<end+1;i++){
            for(int j=0;j<end+1;j++){
                dp[i][j] = -1;
            }
        }
        calcSubArraySum(start,end,nums,dp);
        for(int i = 0;i<end+1;i++){
            for(int j=0;j<end+1;j++){
                if(dp[i][j] == target){
                    if(j-i<ans){
                        ans = j-i;
                        index1 = j;
                        index2 = i;
                    }
                }
            }
        }
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans + 1;
    }

    private int calcSubArraySum(int start, int end, int[] nums, int[][] dp) {

        if(start>end){
            return 0;
        }
        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        if(start == end){
            dp[start][end] = nums[start%nums.length];
            return dp[start][end];
        }
        dp[start][end] = nums[end% nums.length] + calcSubArraySum(start,end-1,nums,dp);
        dp[start][end] = nums[start%nums.length] + calcSubArraySum(start+1,end,nums,dp);
        return dp[start][end];
    }
}
