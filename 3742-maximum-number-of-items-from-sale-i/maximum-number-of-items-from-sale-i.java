class Solution {
    int[][] dp = new int[1001][1501];
    public int solve(int n, int[][] items, int budget, int minPrice, int[] copies) {
        if(n == 0) return budget/minPrice;
        if(dp[n][budget] != 0) return dp[n][budget];

        int take = 0;
        int skip = 0;
        int price = items[n-1][1];

        if(price <= budget) take = 1 + copies[n-1] + solve(n-1, items, budget - price, minPrice, copies);
        skip = solve(n-1, items, budget, minPrice, copies);

        return dp[n][budget] = Math.max(take, skip);
    }

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] copies = new int[n];
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
            int copy = 0;

            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(items[j][0] % items[i][0] == 0) copy++;
            }

            copies[i] = copy;
        }
        for(int[] row : dp) Arrays.fill(row, 0);
        return solve(n, items, budget, minPrice, copies);
    }
}