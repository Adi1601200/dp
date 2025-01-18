package Done;

public class DecodeWays {



    public int numDecodings(String s) {
        int[] a = new int[s.length()+1];
        a[0] = -1;
        for (int i=0;i<s.length();i++){
            a[i+1] = s.charAt(i) - '0';
        }
        int[][] memo = new int[a.length][a.length];

        // Initialize all values to 1
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                memo[i][j] = -1;
            }
        }
        int ans = rec(a,0,0,a.length-1,memo);

        System.out.println("Answer = " + ans);

        return 0;

    }

    private int rec(int[] a, int x, int y, int len, int[][] memo) {



        if(x>len || y>len){
            return 0;
        }

        if(memo[x][y] != -1){
            return memo[x][y];
        }

        if(x==y && a[x]==0){
            memo[x][y] = 0;
            return memo[x][y];
        }
        if(a[x]==0 && a[y]==0){
            memo[x][y] = 0;
            return memo[x][y];
        }

        if(a[x] == 0 && a[y] != 0){
            memo[x][y] = 0;
            return memo[x][y];
        }

        if(a[x]!=0 && x!=y && (a[x]*10)+a[y]>26){
            memo[x][y] = 0;
            return memo[x][y];
        }

        if(Math.max(x, y) == len){
            memo[x][y] = 1;
            return memo[x][y];
        }

        int ans = rec(a,x<y?y+1:x+1,x<y?y+1:x+1, len, memo) + rec(a,x<y?y+1:x+1,x<y?y+2:x+2, len, memo);
        memo[x][y] = ans;
        return memo[x][y];
    }
}
