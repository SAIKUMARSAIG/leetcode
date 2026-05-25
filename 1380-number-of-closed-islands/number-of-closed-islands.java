class Solution {
    public static int closedIsland(int[][] grid) {
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i=0;i<rows; i++){
            for (int j=0;j<cols;j++){
                if (grid[i][j] != 1 && visited[i][j] != true){
                    if (dfs(grid,visited,i,j,rows,cols)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static boolean dfs(int[][] grid,boolean[][] visited,int r,int c,int rows,int cols){
        if (r<0 || c<0 || r>=rows || c >= cols){
            return false;
        }
        if (grid[r][c]==1){
            return true;
        }
        if (visited[r][c]){
            return true;
        }
        visited[r][c] = true;
        boolean down = dfs(grid,visited,r+1,c,rows,cols);
        boolean up = dfs(grid,visited,r-1,c,rows,cols);
        boolean left = dfs(grid,visited,r,c-1,rows,cols);
        boolean right = dfs(grid,visited,r,c+1,rows,cols);
        return up && down && left && right;
    }
}