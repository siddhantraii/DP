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



		//print maze path
		TC is 3(n+m) raised to n + m
		public static int mazepathR(int sr, int sc, int er, int ec){
			if(sr == er && sc == ec) return 1;

			int count = 0;

			if(sc+1 <= ec){
			count += mazepathR(sr,sc+1,er,ec);
			}
			if(sr+1 <= er){
			count += mazepathR(sr + 1, sc,er,ec);
			}
			if(sr + 1 <= er && sc + 1 <= ec)
			count += mazepathR(sr+1,sc+1,er,ec);

			return count;
		}

		public static int mazepathM(int sr, int sc, int er, int ec, int[][] dp){
			if(sr == er && sc == ec) return dp[sr][sc] = 1;

			int count = 0;

			if(dp[sr][sc] != 0) return dp[sr][sc];

			if(sc+1 <= ec){
			count += mazepathR(sr,sc+1,er,ec);
			}
			if(sr+1 <= er){
			count += mazepathR(sr + 1, sc,er,ec);
			}
			if(sr + 1 <= er && sc + 1 <= ec)
			count += mazepathR(sr+1,sc+1,er,ec);

			dp[sr][sc] = count;
		}


		Tc is (n+m)n square
		public static int mazepathT(int SR, int SC, int er, int ec, int[][] dp){
			for(int sr = er; sr>=0; sr--){
				for int sc = ec; sc>=0; sc--{
					if(sr == er && sc == ec) {
						dp[sr][sc] = 1;
						continue;
					}

					int count = 0;

					if(sc+1 <= ec){
					count += dp[sr][sc+1];//mazepathR(sr,sc+1,er,ec);
					}
					if(sr+1 <= er){
					count += dp[sr+1][sc+1];//mazepathR(sr + 1, sc,er,ec);
					}
					if(sr + 1 <= er && sc + 1 <= ec)
					count += dp[sr+1][sc+1];//mazepathR(sr+1,sc+1,er,ec);

					dp[sr][sc] = count;
				}
			}
			return [SR][SC];
		}

		//print maze path with jumps
		public static int mazepathjumpsR(int sr, int sc, int er, int ec){
			if(sr == er && sc == ec) return 1;

			int count = 0;

			for(int jumps = 1; sc + jumps <= ec; jumps++){
			count += mazepathR(sr,sc+1,er,ec);
			}
			for(int jumps = 1; sr + jumps <= er; jumps++){
			count += mazepathR(sr + 1, sc,er,ec);
			}
			for(int jumps = 1; sc + jumps <= ec && sr + jumps <= er; jumps++)
			count += mazepathR(sr+1,sc+1,er,ec);

			return count;
		}

		public static int mazepathjumpsM(int sr, int sc, int er, int ec, int[][] dp){
			if(sr == er && sc == ec) return dp[sr][sc] = 1;

			if(dp[sr][sc] != 0) return dp[sr][sc];  
			int count = 0;
			for(int jumps = 1; sc + jumps <= ec; jumps++){
			count += mazepathR(sr,sc+jumps,er,ec,dp);
			}
			for(int jumps = 1; sr + jumps <= er; jumps++){
			count += mazepathR(sr + jumps, sc,er,ec,dp);
			}
			for(int jumps = 1; sc + jumps <= ec && sr + jumps <= er; jumps++)
			count += mazepathR(sr+jumps,sc+jumps,er,ec,dp);

			return dp[sr][sc] = count;
		}

		public static int mazepathjumpsT(int SR, int SC, int er, int ec, int[][] dp){
			for(int sr = er; sr>=0; sr--){
				for(int sc = ec; sc>=0; sc--){
					if(sr == er && sc == ec) {
						dp[sr][sc] = 1;
						continue;
						}
 
					int count = 0;
					for(int jumps = 1; sc + jumps <= ec; jumps++){
					count += dp[sr][sc+jumps];//mazepathR(sr,sc+jumps,er,ec,dp);
					}
					for(int jumps = 1; sr + jumps <= er; jumps++){
					count += dp[sr+jumps][sc];//mazepathR(sr + jumps, sc,er,ec,dp);
					}
					for(int jumps = 1; sc + jumps <= ec && sr + jumps <= er; jumps++)
					count += dp[sr+jumps][sc+jumps];//mazepathR(sr+jumps,sc+jumps,er,ec,dp);

					dp[sr][sc] = count;
				}
			}
			return dp[SR][SC];
		}


		//dice -- boardpath
		public static int boardR(int sp, int ep){
			if(sp == ep) return 1;
			int count = 0;
			for(int dice = 1; dice<=6 && sp + dice <= ep; dice++){
				count += board(sp + dice,ep);
			}
			return count;
		}

		public static int boardM(int sp, int ep, int[]dp){
			if(sp == ep) return dp[sp] = 1;
			int count = 0;
			if(dp[sp] != 0) return dp[sp];
			for(int dice = 1; dice<=6 && sp + dice <= ep; dice++){
				count += board(sp + dice,ep,dp);
			}
			return dp[sp] = count;
		}

		TC - 6 n
		public static int boardT(int SP, int ep, int[]dp){
			for(int sp = ep; sp>=0; sp--){
					if(sp == ep) {
						dp[sp] = 1;
						continue;
					}
					int count = 0;
					
					for(int dice = 1; dice<=6 && sp + dice <= ep; dice++){
						count += dp[sp + dice];//board(sp + dice,ep,dp);
					}
					dp[sp] = count;
			}
			return dp[SP];
		}

		//optimisation - 


		LC - 70 Climbing Stairs

		//TLE
		public int climbStairsR(int n) {
        	return helpme(n,0);
	    }
	    
	    public int helpme(int n, int s){
	        if(s==n) return 1;
	        
	        int ans = 0;
	        if(s + 1 <= n){
	            ans+= helpme(n,s+1);
	        }
	        if(s + 2 <= n){
	            ans+= helpme(n,s+2);
	        }
	        return ans;
	    }


	    //passed
	    public int climbStairsM(int n) {
        	return helpme(n,0,new int[n+1]);
	    }
	    
	    public int helpme(int n, int s,int []dp){
	        if(s==n) return dp [s] = 1;
	        
	        int ans = 0;
	        if(dp[s] != 0) return dp[s];
	        if(s + 1 <= n){
	            ans+= helpme(n,s+1,dp);
	        }
	        if(s + 2 <= n){
	            ans+= helpme(n,s+2,dp);
	        }
	        return dp[s] = ans;
	    }

	    //passed
	    public int climbStairsT(int n) {
        	return helpme(n,0,new int[n+1]);
	    }
	    
	    public int helpme(int n, int S,int []dp){
	    	for(int s = n; s>= 0; s--){
	        if(s==n) {
	        	dp [s] = 1;
	        	continue;
	        }

	        int ans = 0;
	        if(s + 1 <= n){
	            ans+= dp[s+1];//helpme(n,s+1,dp);
	        }
	        if(s + 2 <= n){
	            ans+= dp[s+2];//helpme(n,s+2,dp);
	        }
	        dp[s] = ans;
	    	}
	    	return dp[0];
		}


}