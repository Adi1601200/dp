package Done;
/*You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

        Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

        0 <= j <= nums[i] and
        i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



        Example 1:

        Input: nums = [2,3,1,1,4]
        Output: 2
        Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
        Example 2:

        Input: nums = [2,3,0,1,4]
        Output: 2


        Constraints:

        1 <= nums.length <= 104
        0 <= nums[i] <= 1000
        It's guaranteed that you can reach nums[n - 1].*/

import java.util.Arrays;

import static java.lang.Math.min;

public class JumpProblemDP {
    public boolean jump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp,-2);
        return calculateJump(0, nums.length - 1, nums, dp) != Integer.MAX_VALUE / 2;
    }

    private int calculateJump(int start, int end, int[] nums, int[] dp){
        if(start>=nums.length){
            return Integer.MAX_VALUE / 2;
        }
        if(dp[start]!=-2){
            return dp[start];
        }

        if(start == end){
            dp[start] = 0;
            return 0;
        }

        int ans = Integer.MAX_VALUE/2;
        for(int i = start + 1 ; i <= start + nums[start] && i < nums.length; i++){
            int value = calculateJump(i,end, nums, dp);
            if(dp[i] != -2 && dp[i]>value){
                dp[i] = value;
            }else{
                if(dp[i] == -2){
                    dp[i] = value;
                }
            }
            if(dp[i]<ans && dp[i]!=-2){
                ans = 1 + dp[i];
            }
        }
        dp[start] = ans;
        return ans;

    }
}
