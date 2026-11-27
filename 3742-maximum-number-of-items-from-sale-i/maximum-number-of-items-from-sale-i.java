class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] copies = new int[n];
        int[][] dp = new int[1001][1501];
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

        for(int b = 0; b <= budget; b++) {
            dp[0][b] = b/minPrice; 
        }

        for(int i = 1; i <= n; i++) {
            for(int b = 0; b <= budget; b++) {
                int take = 0;
                int price = items[i-1][1];

                if(price <= b) take = 1 + copies[i-1] + dp[i-1][b - price];
                int skip = dp[i-1][b];
                dp[i][b] = Math.max(take, skip); 
            }
        }
        return dp[n][budget];
    }
}