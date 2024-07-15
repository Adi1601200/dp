package Done;

public class JumpProblem1 {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        return determineJump(0,nums.length-1,nums,dp);
    }

    private boolean determineJump(int start, int end, int[] nums, int[] dp) {

        if(dp[start]!=0){
            if(dp[start] == 1){
                return true;
            }
            if(dp[start]==2){
                return false;
            }
        }
        if(start == end){
            return true;
        }

        if(start + nums[start] >= end){
            return true;
        }

        if(nums[start] == 0){
            return false;
        }else{
            boolean finalLocal = false;
            for(int i = start+1;i<end && i <= start + nums[start];i++){
                if(determineJump(i,end,nums, dp)){
                    dp[i] = 1;
                }else{
                    dp[i] = 2;
                }
                if(dp[i] == 1){
                    finalLocal = finalLocal || true;
                }
                if(dp[i]==2){
                    finalLocal = finalLocal || false;
                }

            }
            return finalLocal;
        }
    }


}
