LC - 516
class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for(int [] d : dp){
            Arrays.fill(d,-1);
        }
        return help(s,0,s.length()-1,dp);
    }
    
    public static int help(String s, int i, int j, int dp[][]){
        if(i >= j) return dp[i][j] = (i == j) ? 1 : 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = help(s,i+1,j-1,dp) + 2;
        
        return dp[i][j] = Math.max(help(s,i+1,j,dp),help(s,i,j-1,dp));
    }
}

class Solution {
    public int longestPalindromeSubseqTabulated(String s) {
        int dp[][] = new int[s.length()][s.length()];
        return help(s,0,s.length()-1,dp);
    }
    public static int help(String s, int I, int J, int dp[][]){
        for(int gap = 0; gap < s.length(); gap++){
            for(int i = 0, j = gap ; j<s.length() ; i++, j++){
                if(i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2; 
                } 
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[I][J];
    }
}

//if we try to find the longest palindromic subsequence --- String Dp
public static int longestPalindromeSubseqStringTabulated(String s,String dp[][]){

        for(int gap = 0; gap < s.length(); gap++){
            for(int i = 0, j = gap ; j<s.length() ; i++, j++){
                if(i == j) {
                    dp[i][j] = s.charAt(i) + "";
                    continue;
                }
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = s.charAt(i) + s.charAt(dp[i+1][j-1]) + s.charAt(j);
                } 
                else dp[i][j] = (dp[i+1][j].length() > dp[i][j-1].length()) ? dp[i+1][j] : dp[i+1][j-1] ;
            }
        }
        return dp[0][s.length()-1];
    }


-------------------------Another method - Back Engineering See notes

-------------------------------------------------------------------------------------------
LC - 115

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][]dp = new int[n+1][m+1];
        for(int [] d:dp) Arrays.fill(d,-1);
        return numDistinct_memo(s,t,n,m,dp);
    }
    
    public static int numDistinct_memo(String s, String t, int n, int m, int[][]dp){
        if(m==0) {
            return dp[n][m] = 1;
        }
        
        if(n<m){
            return dp[n][m] = 0;
        }
        
        if(dp[n][m] != -1) return dp[n][m];
        
        if(s.charAt(n-1) == t.charAt(m-1)) dp[n][m] = numDistinct_memo(s,t,n-1,m-1,dp) + numDistinct_memo(s,t,n-1,m,dp);
        
        else dp[n][m] = numDistinct_memo(s,t,n-1,m,dp);
        
        return dp[n][m];
    }
}


class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][]dp = new int[n+1][m+1];
        return numDistinct_Tabulated(s,t,n,m,dp);
    }
    
    public static int numDistinct_Tabulated(String s, String t, int N, int M, int[][]dp){
        
        for(int n = 0; n<=N; n++){
            for(int m = 0; m<=M; m++){
                
            if(m==0) {
                dp[n][m] = 1;
                continue;
            }
        
            if(n < m){
                dp[n][m] = 0;
                continue;
            }
        
            if(s.charAt(n-1) == t.charAt(m-1)) dp[n][m] = dp[n-1][m-1] + dp[n-1][m];
            else dp[n][m] = dp[n-1][m];
                
            }
        }
        return dp[N][M];
    }
}

----------------------------------------------------------------------------------------------------
LC - 1143

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][]dp = new int[n+1][m+1];
        for(int [] d: dp) Arrays.fill(d,-1);
        return LCS_memo(text1,text2,n,m,dp);
    }
    public static int LCS_memo(String text1, String text2, int n, int m, int[][]dp){
        if(n == 0 || m == 0) return 0;
        
        if(dp[n][m] != -1) return dp[n][m];
        
        if(text1.charAt(n-1) == text2.charAt(m-1)) dp[n][m] = LCS_memo(text1,text2,n-1,m-1,dp) + 1;
        else dp[n][m] = Math.max(LCS_memo(text1,text2,n-1,m,dp),LCS_memo(text1,text2,n,m-1,dp));
        return dp[n][m];
    }
}


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][]dp = new int[n+1][m+1];
        return LCS_Tabulated(text1,text2,n,m,dp);
    }
    public static int LCS_Tabulated(String text1, String text2, int N, int M, int[][]dp){
        for(int n = 0; n<=N; n++){
            for(int m = 0; m<=M; m++){
                if(n == 0 || m == 0) {
                    dp[n][m] =  0;
                    continue;
                }
        
            if(text1.charAt(n-1) == text2.charAt(m-1)) dp[n][m] = dp[n-1][m-1] + 1;
            else dp[n][m] = Math.max(dp[n-1][m],dp[n][m-1]);

            }
        }
        return dp[N][M];
    }
}


---------------------------------------------------------------------------
LC - 1035(same as before)
class Solution {
    public int maxUncrossedLines(int[] text1, int[] text2) {
        int n = text1.length;
        int m = text2.length;
        int [][]dp = new int[n+1][m+1];
        for(int [] d: dp) Arrays.fill(d,-1);
        return LCS_memo(text1,text2,n,m,dp);
    }
    public static int LCS_memo(int[] text1, int[] text2, int n, int m, int[][]dp){
        if(n == 0 || m == 0) return dp[n][m] = 0;
        
        if(dp[n][m] != -1) return dp[n][m];
        
        if(text1[n-1] == text2[m-1]) dp[n][m] = LCS_memo(text1,text2,n-1,m-1,dp) + 1;
        else dp[n][m] = Math.max(LCS_memo(text1,text2,n-1,m,dp),LCS_memo(text1,text2,n,m-1,dp));
        return dp[n][m];
    }
}

//tabulated
class Solution {
    public int maxUncrossedLines(int[] text1, int[] text2) {
        int n = text1.length;
        int m = text2.length;
        int [][]dp = new int[n+1][m+1];
        return LCS_memo(text1,text2,n,m,dp);
    }
    public static int LCS_memo(int[] text1, int[] text2, int N, int M, int[][]dp){
        for(int n = 0; n<=N; n++){
            for(int m = 0; m<=M; m++){
                if(n == 0 || m == 0) {
                    dp[n][m] =  0;
                    continue;
                }
        
            if(text1[n-1] == text2[m-1]) dp[n][m] = dp[n-1][m-1] + 1;
            else dp[n][m] = Math.max(dp[n-1][m],dp[n][m-1]);

            }
        }
        return dp[N][M];
    }
}


