package Done;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class UniquePathsDP {
    public int uniquePaths(int m, int n) {
        AtomicInteger branchesCalculated = new AtomicInteger(0);
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = paths(m-1,n-1,dp,branchesCalculated);
        System.out.println("BranchesCalculated = " + branchesCalculated.get() + "\n");
        return ans ;
    }

    private int paths(int i, int j, int[][] dp, AtomicInteger branchesCalculated) {

        if(i==0&&j==0){
            return 1;
        }
        if(i<0||j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        branchesCalculated.set(branchesCalculated.get()+1);
        int ans = paths(i-1,j, dp, branchesCalculated) + paths(i,j-1, dp, branchesCalculated);
        dp[i][j] = ans;
        return ans;
    }
}
