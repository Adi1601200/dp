package Done;

public class UniquePathsDP2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int numRows = obstacleGrid.length;
        int numCols = obstacleGrid[0].length;
        int[][] dp = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = paths(numRows-1,numCols-1,dp,obstacleGrid);
        return ans;
    }

    private int paths(int i, int j, int[][] dp, int[][] obstacle) {
        if(i==0&&j==0){
            if(obstacle[i][j] == 1){
                return 0;
            }
            return 1;
        }
        if(i<0||j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(obstacle[i][j] == 1){
            dp[i][j] = 0;
            return 0;
        }
        int ans = paths(i-1,j, dp, obstacle) + paths(i,j-1, dp, obstacle);
        dp[i][j] = ans;
        return ans;
    }
}
