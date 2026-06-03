class Solution {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i =0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (board[i][j] == word.charAt(0) &&
            search(board, word, i, j, rows, cols, 0, visited)) {
            return true;
        }
            }
        }
        return false;
    }

    public static boolean search(char[][] grid,String word,int i,int j , int rows,int cols,int idx,boolean[][] visited){
        if (i<0 || j<0 || i>=rows || j>= cols || grid[i][j] != word.charAt(idx) || visited[i][j] == true){
            return false;
        }
        if(idx == word.length()-1){
            return true;
        }
        
        visited[i][j] = true;
        boolean up = search(grid,word,i-1,j,rows,cols,idx+1,visited);
        boolean right = search(grid,word,i,j+1,rows,cols,idx+1,visited);
        boolean down = search(grid,word,i+1,j,rows,cols,idx+1,visited);
        boolean left = search(grid,word,i,j-1,rows,cols,idx+1,visited);
        visited[i][j] = false;

        return down || up || right || left;
    }
}