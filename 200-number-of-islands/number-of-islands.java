class Solution {
    int m;
    int n;
    int[] dr = {0,0,-1,1};
    int[] dc = {1,-1,0,0};
    boolean[][] visited;

    public boolean isValid(char[][] grid, int row, int col) {
        if(row < 0 || row >= m || col < 0 || col >=n) return false;
        if(grid[row][col] == '0') return false;
        if(visited[row][col]) return false;
        return true;
    }

    public void dfs(char[][] grid, int row, int col) {
        visited[row][col] = true;
        for(int k = 0; k < 4; k++) {
            int nrow = row + dr[k];
            int ncol = col + dc[k];

            if(isValid(grid, nrow, ncol)) {
                dfs(grid, nrow, ncol);
            }
        }
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}