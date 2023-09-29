class Solution {
    
    int [] [] directions = new int [] [] {{1, 0}, {0, 1}, {-1, 0}, {0, -1},
                                          {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        
        int row = click[0], col = click[1];
        
        if(board[row][col] == 'M'){
            board[row][col] = 'X';
            return board;
        }
        
        dfs(board, row, col);
        
        return board;
    }
    
    private void dfs(char[][] board, int row, int col){
        
        if(isBorder(board, row, col) || board[row][col] != 'E'){
            return;
        }
        
        int count = 0;
        
        for(int [] dir: directions){
            int nextRow = dir[0] + row, nextCol = dir[1] + col;
            if(isBorder(board, nextRow, nextCol)){
                continue;
            }
            if(board[nextRow][nextCol] == 'M'){
                count++;
            }
        }
        
        if(count > 0){
            board[row][col] = (char)(count + '0');
            return;
        }
        
        board[row][col] = 'B';
        
         for(int [] dir: directions){
            int nextRow = dir[0] + row, nextCol = dir[1] + col;
            dfs(board, nextRow, nextCol);
         }
    }
    
    private boolean isBorder(char[][] board, int row, int col){
        return row < 0 || row == board.length || col < 0 || col == board[0].length;
    }
}