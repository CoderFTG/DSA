class Solution {
    public int cherryPickup(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];

        // Base Case
        for (int j1 = 0; j1 < cols; j1++) {
            for (int j2 = 0; j2 < cols; j2++) {

                if (j1 == j2)
                    dp[rows - 1][j1][j2] = grid[rows - 1][j1];
                else
                    dp[rows - 1][j1][j2] =
                            grid[rows - 1][j1] + grid[rows - 1][j2];
            }
        }

        // Fill DP Bottom-Up
        for (int i = rows - 2; i >= 0; i--) {

            for (int j1 = 0; j1 < cols; j1++) {

                for (int j2 = 0; j2 < cols; j2++) {

                    int max = (int) -1e8;

                    for (int d1 = -1; d1 <= 1; d1++) {

                        for (int d2 = -1; d2 <= 1; d2++) {

                            int value;

                            if (j1 == j2)
                                value = grid[i][j1];
                            else
                                value = grid[i][j1] + grid[i][j2];

                            int nj1 = j1 + d1;
                            int nj2 = j2 + d2;

                            if (nj1 >= 0 && nj1 < cols &&
                                nj2 >= 0 && nj2 < cols)
                                value += dp[i + 1][nj1][nj2];
                            else
                                value += (int) -1e8;

                            max = Math.max(max, value);
                        }
                    }

                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][cols - 1];
    }
}