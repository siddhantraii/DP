GFG count all palindromes------------------------------------------------------
class Solution
{
    int mod = (int)1e9 + 7;
    long countPS(String str)
    {
       int n = str.length();
       long [][] dp = new long[n][n];
       for(long[] d:dp) Arrays.fill (d,-1);
       return call(str,0,n-1,dp);
    }
    
    long call(String str,int i, int j, long[][]dp){
        if(i >= j) return dp[i][j] = (i==j) ? 1 : 0 ; 
        
        if(dp[i][j] != -1) return dp[i][j];
        long a = call(str,i+1,j,dp);
        long b = call(str,i,j-1,dp);
        long c = call(str,i+1,j-1,dp);
        
        if(str.charAt(i) == str.charAt(j)) return dp[i][j] = a + b + 1;
        else return dp[i][j] = (a + b - c + mod )%mod;
    }
}