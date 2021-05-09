public class DP1{

	public static int fiboR(int n){
	if(n<=1) return n;
	int ans = fiboR(n-1) + fiboR(n-2);
	return ans;
	}

	public static int fiboM(int n, int[] dp){
	if(n<=1){
		return dp[n] = n;
	} 

	if(dp[n] != -1) return dp[n];
	int ans = fiboR(n-1,dp) + fiboR(n-2,dp);

	return dp[n] = ans;
	}

	public static int fiboM(int N, int[] dp){
		for(int n = 0; n<=N; n++){
			if(n<=1){
				dp[n] = n;
				continue;
			} 

			int ans = dp[n-1] + dp[n-2]; //fiboR(n-1,dp) + fiboR(n-2,dp);

			dp[n] = ans;
			}
		}
}