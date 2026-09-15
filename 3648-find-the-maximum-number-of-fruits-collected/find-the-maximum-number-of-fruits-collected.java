class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int[][] dp = new int[n][n];

        //child1 collect fruits
        int result = 0;
        for(int i = 0; i < n; i++) {
            result += fruits[i][i];
        }

        //Nullify the values where child2 and child3 can't visit
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i < j && i+j < n-1) {
                    dp[i][j] = 0;
                }
                else if(i > j && i+j < n-1) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = fruits[i][j];
                }
            }
        }

        //child2 collect fruits -- Upper Diagonal (i < j)
        for(int i = 1; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                dp[i][j] += Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], (j+1 < n) ? dp[i-1][j+1] : 0));
            }
        }

        //child3 collect fruits -- Lower Diagonal (i > j)
        for(int j = 1; j < n; j++) {
            for(int i = j + 1; i < n; i++) {
                dp[i][j] += Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], (i+1 < n) ? dp[i+1][j-1] : 0));
            }
        }

        return result + dp[n-2][n-1] + dp[n-1][n-2];
    }
}