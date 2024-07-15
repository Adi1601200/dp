package Done;

public class UniqueBinarySearchTree {
    public int numTrees(int n) {

        int[][] memo = new int[n][n];

        // Initialize all values to 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return btree(0,n-1,memo);

    }

    private int btree(int i, int i1, int[][] memo) {
        if(i1<i){
            return 1;
        }
        if(memo[i][i1]!=-1){
            return memo[i][i1];
        }
        if(i1-i==1){
            return 2;
        }
        if(i1-i==0){
            return 1;
        }
        int ans = 0;
        for(int j=i;j<=i1;j++){
            ans += btree(i,j-1, memo) * btree(j+1,i1, memo);
        }
        memo[i][i1] = ans;
        return memo[i][i1];
    }
}
