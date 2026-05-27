class Pairs{
    int row;
    int col;

    Pairs(){}
    public Pairs(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}

class Solution {
    public static int numEnclaves(int[][] grid) {
        int ans = 0;
        int row = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[row][cols];
        Queue<Pairs> queue = new LinkedList<>();
        for (int i=0;i<row;i++){
            for (int j=0;j<cols;j++){
                if (i==0 || i==row-1 || j==0 || j==cols-1){
                    int num = grid[i][j];
                    if (num == 1){
                        visited[i][j] = 1;
                        queue.add(new Pairs(i,j));
                    }
                }
            }
        }
//        System.out.println(queue);
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        while (!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            queue.remove();
            for (int i=0;i<4;i++){
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if (nrow>=0 && nrow<row && ncol>=0 && ncol < cols  && grid[nrow][ncol] == 1
                        && visited[nrow][ncol] == 0){
                    queue.add(new Pairs(nrow,ncol));
                    visited[nrow][ncol] = 1;
                }
            }
        }
        for (int i=0;i<row;i++){
            for (int j=0;j<cols;j++){
                if (grid[i][j]==1 && visited[i][j]==0){
                    ans++;
                }
            }
        }
        return ans;
    }
}