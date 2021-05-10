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

	public static int fiboT(int N, int[] dp){
		for(int n = 0; n<=N; n++){
			if(n<=1){
				dp[n] = n;
				continue;
			} 

			int ans = dp[n-1] + dp[n-2]; //fiboR(n-1,dp) + fiboR(n-2,dp);

			dp[n] = ans;
			}
			return dp[N];
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

//_________________________________________________________________________________________________________________________
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

//LC - 746__________________________________________________________________________________________________________
		public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return minCost(cost,n);
   		}
    
    	//recursive TLE
	    public int minCostR(int [] cost, int dest){
        if(dest <= 1) return cost[dest];
        
        int mincost = 0;
        
        mincost += Math.min(minCostR(cost,dest - 1),minCostR(cost,dest - 2)) + (dest == cost.length ? 0 : cost[dest]);
        
        return mincost;
    	}

    	//memoised ACCEPTED
    	public int minCostM(int [] cost, int dest,int [] dp){
        if(dest <= 1) return dp[dest] = cost[dest];
        
        int mincost = 0;

  		if(dp[dest] != -1) return dp[dest];

        mincost += Math.min(minCostM(cost,dest - 1,dp),minCostM(cost,dest - 2,dp)) + (dest == cost.length ? 0 : cost[dest]);
        
        return dp[dest] = mincost;
    	}

    	//tabulated ACCEPTED
    	public int minCostT(int [] cost, int dest,int [] dp){
    		for(int d = 0; d <= dest; d++){
    			if(d <= 1) {
    				dp[d] = cost[d];
    				continue;
        		}
		        int mincost = 0;
		        mincost += Math.min(dp[d-1],dp[d-2]) + (d == dest ? 0 : cost[d]);
		        dp[d] = mincost;
    		}
        	return dp[dest];
    	}

    	//friends pairing GFG __________________________________________________________________________________________________________
    	// 1 - Recursive
    	public long countFriendsPairingsR(int n) 
	    { 
	       if(n<=1) return 1;
	        
	        long single = countFriendsPairings(n-1);
	        long pair = countFriendsPairings(n-2) * (n-1);
	        
	        return single + pair;
	    }

	    //2 - Memoised PASSED
	    public long countFriendsPairingsM(int n, long[] dp) 
	    { 
	       if(n<=1) {
	       	return dp[n] = 1;
	        }

	        if(dp[n] != 0) return dp[n];

	        long single = countFriendsPairingsM(n-1,dp);
	        long pair = countFriendsPairingsM(n-2,dp) * (n-1);
	        
	        return dp[n] = (single % mod + pair % mod) % mod;
	    }


	    //3 - tabulated PASSED
	    public long countFriendsPairingsT(int N, long[] dp) 
	    { 
	    	for(int n = 0; i<=N; i++){
		        if(n<=1) {
		       	dp[n] = 1;
		       	continue;
		        }

		        if(dp[n] != 0) return dp[n];

		        long single = dp[n-1];//countFriendsPairingsR(n-1,dp);
		        long pair = dp[n-2] * (n-1);//countFriendsPairingsR(n-2,dp) * (n-1);
		        
		        dp[n] = (single % mod + pair % mod) % mod;
	    	}
	    	return dp[N];
	    }

	    //to print all substrings
	    public static long printFriendsPairing(String friends, String ans) {
        if (friends.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        char ch = friends.charAt(0);
        long count = 0;
        count += printFriendsPairing(friends.substring(1), ans + ch + " ");
        for (int i = 1; i < friends.length(); i++) {
            String rstr = friends.substring(1, i) + friends.substring(i + 1);
            count += printFriendsPairing(rstr, ans + ch + friends.charAt(i) + " ");
        }

        return count;
    }

//Goldmine GFG___________________________________________________________________________________________________________________________________
    	static int maxGold(int n, int m, int M[][])
    {
       int[][] dp = new int[n][m];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, helpM(i, 0, M, dp, dir));
        }
        return maxGold;
    }
    
    static int helpM(int n, int m, int M[][], int[][] dp, int[][] dir){
        if(m == M[0].length-1){
            return dp[n][m] = M[n][m];
        }
        
        if(dp[n][m] != -1) return dp[n][m];
        
        int ans = 0;
        for(int i = 0; i<dir.length; i++){
            int x = n + dir[i][0];
            int y = m + dir[i][1];
            
            if(x >=0 && x< M.length && y<M[0].length && y>=0){
                ans = Math.max(ans,helpM(x,y,M,dp,dir));
            }
        }
        return dp[n][m] = ans + M[n][m];
    }
======================================= DP solution
    static int maxGold(int n, int m, int M[][])
    {
        int[][] dp = new int[n][m];
        for (int[] d : dp){
            Arrays.fill(d, -1);
        }
        int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

        help(M,dp,dir);
        
        int maxGold = 0;
        for (int i = 0; i < M.length; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }
        return maxGold;
    }
    
    static int help(int M[][], int[][] dp, int[][] dir){
        for(int m = M[0].length - 1; m>=0; m--){
        for(int n = M.length - 1; n>=0; n--){
            
            if(m == M[0].length-1){
                dp[n][m] = M[n][m];
                continue;
            }
        
        int ans = 0;
        for(int i = 0; i<dir.length; i++){
            int x = n + dir[i][0];
            int y = m + dir[i][1];
                
            if(x >=0 && x< M.length){
                ans = Math.max(ans,dp[x][y]);
            }
        }
            dp[n][m] = ans + M[n][m];
        }
    }
    
    return dp[0][0];
    }
    }

}