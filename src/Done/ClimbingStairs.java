package Done;

import java.util.Arrays;

public class ClimbingStairs {

    public int climbStairs(int n) {
    int[] memo = new int[n+1];
    Arrays.fill(memo,-1);
    return climb(n,memo);
    }

    int climb(int n,int[] memo){
        if(n==2){
            return 2;
        }
        if(n==1){
            return 1;
        }
        if(n<=0){
            return 0;
        }
        if(memo[n]!=-1){
            return memo[n];
        }
        memo[n] = climb(n-1,memo) + climb(n-2,memo);
        return memo[n];
    }
}
