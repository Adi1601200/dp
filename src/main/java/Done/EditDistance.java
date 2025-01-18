package Done;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length()+1;
        int n = word2.length()+1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return calcDist(word1,word2,0,0,dp);
    }

    private int calcDist(String word1, String word2, int fpos, int spos, int[][] dp) {
        if(fpos>word1.length()-1 || spos>word2.length()-1){
            if(fpos==word1.length() && spos==word2.length()){
                dp[fpos][spos] = 0;
                return dp[fpos][spos];
            }else{
                if(spos==word2.length() && fpos<word1.length()){
                    dp[fpos][spos] = word1.length()-fpos;
                    return dp[fpos][spos];
                }else if(fpos == word1.length() && spos<word2.length()){
                    dp[fpos][spos] = word2.length()-spos;
                    return dp[fpos][spos];
                }
            }
        }
        if(dp[fpos][spos] != -1){
            return dp[fpos][spos];
        }
        if(word1.charAt(fpos) == word2.charAt(spos)){
            dp[fpos][spos] = calcDist(word1,word2,fpos+1,spos+1, dp);
            return dp[fpos][spos];
        }else{
            dp[fpos][spos] = 1 + Math.min(calcDist(word1,word2,fpos,spos+1, dp) //insert
                    ,Math.min(calcDist(word1,word2,fpos+1,spos, dp) //delete
                            , calcDist(word1,word2,fpos+1,spos+1, dp)) //replace
            );
            return dp[fpos][spos];
        }
    }
}
