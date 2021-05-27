LC - 91 Decode Ways-----------------------------------------------------------

(TLE Recursion)
public int helpR(String s, int idx){
        if(idx == s.length()) return 1;
        char ch = s.charAt(idx);
        if(ch == '0') return 0; 
        
        int count = 0;
        count += help(s,idx+1);
        
        if(idx < s.length() - 1){
            char ch2 = s.charAt(idx + 1);
            int num = (ch - '0') * 10 + ch2 - '0';
            if(num <= 26) count += help(s,idx+2);
        }
        
        return count;
    }

(we will fill the array with -1 too before calling this function)
public int helpM(String s, int idx, int[] dp){
        if(idx == s.length()) return dp[idx] = 1;
        char ch = s.charAt(idx);
        if(ch == '0') return dp[idx] = 0; 
        
        if(dp[idx] != -1) return dp[idx];
        int count = 0;
        count += helpM(s,idx+1,dp);
        
        if(idx < s.length() - 1){
            char ch2 = s.charAt(idx + 1);
            int num = (ch - '0') * 10 + ch2 - '0';
            if(num <= 26) count += helpM(s,idx+2,dp);
        }
        
        return dp[idx] = count;
    }

   public int helpT(String s, int[] dp){
    	for(int idx = s.length(); idx>=0; idx--){
        if(idx == s.length()) {
        	dp[idx] = 1;
        	continue;
        }
        char ch = s.charAt(idx);
        if(ch == '0') {
        	dp[idx] = 0; 
        	continue;
        }
        
        int count = 0;
        count += dp[idx+1];//helpT(s,idx+1,dp);
        
        if(idx < s.length() - 1){
            char ch2 = s.charAt(idx + 1);
            int num = (ch - '0') * 10 + ch2 - '0';
            if(num <= 26) count += dp[idx+2];//helpT(s,idx+2,dp);
        }
        dp[idx] = count;
    }
    return dp[0];
    }



LC - 639 Decode Ways II-----------------------------------------------------------
------Memoisation
class Solution {
    int mod = (int)1e9 + 7;
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        Arrays.fill(dp,-1);
        long ans =  numDecordings_memo(s,0,dp);
        return (int) ans;
    }
    
    public long numDecordings_memo(String s, int idx, long[]dp){
        if(idx == s.length()) return dp[idx] = 1;
        if(s.charAt(idx) == '0') return dp[idx] = 0;
        if(dp[idx] != -1) return dp[idx];
        
        
        long count = 0;
        char ch1 = s.charAt(idx);
        if(ch1 == '*'){
            count = (count + 9 * numDecordings_memo(s,idx+1,dp)) % mod;
            if(idx < s.length() - 1){
                char ch2 = s.charAt(idx+1);
                if(ch2 == '*'){
                    count = (count + 15 * numDecordings_memo(s,idx+2,dp)) % mod;
                }
                else if(ch2 >= '0' && ch2 <= '6') count = (count + 2 * numDecordings_memo(s,idx+2,dp)) % mod;
                else if(ch2 > '6') count = (count + numDecordings_memo(s,idx+2,dp)) % mod;
                
            }
        }
        
        else{
            count = (count + numDecordings_memo(s,idx+1,dp)) % mod;
            if(idx < s.length() - 1){
                char ch2 = s.charAt(idx+1);
                if(ch2 != '*'){
                    int num = (ch1 - '0') * 10 + (ch2 - '0');
                    if(num <= 26){
                        count = (count + numDecordings_memo(s,idx+2,dp)) % mod;
                    }
                }
                else{
                    if(s.charAt(idx) == '1') count = (count + 9 * numDecordings_memo(s,idx+2,dp)) % mod;
                    else if(s.charAt(idx) == '2') count = (count + 6 * numDecordings_memo(s,idx+2,dp)) % mod;
                }
            }
        }
        
        return dp[idx] = count;
    }
}

----Tabulation
class Solution {
    int mod = (int)1e9 + 7;
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        long ans =  numDecordings_memo(s,0,dp);
        return (int) ans;
    }
    
    public long numDecordings_memo(String s, int IDX, long[]dp){
        for(int idx = s.length(); idx>=0; idx--){
        if(idx == s.length()){
            dp[idx] = 1;
            continue;
        } 
        if(s.charAt(idx) == '0') {
            dp[idx] = 0;
            continue;
        }
        
        long count = 0;
        char ch1 = s.charAt(idx);
        if(ch1 == '*'){
            count = (count + 9 * dp[idx+1]) % mod;
            if(idx < s.length() - 1){
                char ch2 = s.charAt(idx+1);
                if(ch2 == '*') count = (count + 15 * dp[idx+2]) % mod;
                else if(ch2 >= '0' && ch2 <= '6') count = (count + 2 * dp[idx+2]) % mod;
                else if(ch2 > '6') count = (count + dp[idx+2]) % mod;
            }
        }
        
        else{
            count = (count + dp[idx+1]) % mod;
            if(idx < s.length() - 1){
                char ch2 = s.charAt(idx+1);
                if(ch2 != '*'){
                    int num = (ch1 - '0') * 10 + (ch2 - '0');
                    if(num <= 26){
                        count = (count + dp[idx+2]) % mod;
                    }
                }
                else{
                    if(s.charAt(idx) == '1') count = (count + 9 * dp[idx+2]) % mod;
                    else if(s.charAt(idx) == '2') count = (count + 6 * dp[idx+2]) % mod;
                }
            }
        }
        
        dp[idx] = count;
    }
        return dp[IDX];
    }
}

----------------------------------------------------------------------------------------------------

GFG - https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/

public static int noOfWays(int n, int k, int[][] dp) {
	if(n==0 || k ==0 || k > n) return dp[n][k] = 0;
	if(k == 1) return dp[n][k] = 1;
	if(n == k) return dp[n][k] = 1;`
	if(dp[n][k] != -1) return dp[n][k];
	 
	int alone += noOfWays(n-1,k-1,dp);
	int willpairlater += noOfWays(n-1,k,dp) * k;

	return dp[n][k] = alone + willpairlater;
}

public static int noOfways_Tabulated(int N, int K, int [][]dp){
for(int n = 0; n<=N; n++){
	for(int k = 0; k<=K; k++){
		if(n == 0 || k == 0 || k>n){
			dp[n][k] = 0;
			continue;
		}

		if(n == k || n == 1 ){
			dp[n][k] = 1;
			continue;
		}

		dp[n][k] = dp[n-1][k-1] + (dp[n-1][k] * k);
	}
}

return dp[N][K];
}