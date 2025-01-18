package Done;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int numRows = grid.length-1; // Number of rows
        int numCols = grid[0].length-1; // Number of columns (assuming all rows have the same number of columns)
        int [][] memo = new int[numRows+1][numCols+1];
        for (int i = 0; i < numRows+1; i++) {
            for (int j = 0; j < numCols+1; j++) {
                memo[i][j] = -1;
            }
        }
        int answer = minPath(grid,numRows,numCols,numRows,numCols,memo);
        return answer;
    }

    private int minPath(int[][] grid, int m, int n, int row, int column, int[][] memo){
        if(m==0&&n==0){
            return grid[0][0];
        }
        if(m<0 || n<0){
            return Integer.MAX_VALUE;
        }
        if(memo[m][n]!=-1){
            return memo[m][n];
        }
        memo[m][n] =  grid[m][n] + Math.min(minPath(grid,m-1,n,row,column, memo),minPath(grid,m,n-1,row,column, memo));
        return memo[m][n];
    }
}
