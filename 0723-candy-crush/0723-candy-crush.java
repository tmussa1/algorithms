class Solution {
    
    public int[][] candyCrush(int[][] board) {
        
        int rows = board.length, cols = board[0].length;
        
        while(true){
            
            boolean crush = true;
            
            boolean [] [] crushed = new boolean [rows][cols];
            
            for(int row = 0; row < rows; row++){
                for(int col = 0; col < cols - 2; col++){
                    if(board[row][col] != 0 && board[row][col] == board[row][col + 1] && board[row][col] == board[row][col + 2]){
                        crushed[row][col] = true;
                        crushed[row][col + 1] = true;
                        crushed[row][col + 2] = true;
                        crush = false;
                    }
                }
            }
            
           for(int col = 0; col < cols; col++){
             for(int row = 0; row < rows - 2; row++){
                    if(board[row][col] != 0 && board[row][col] == board[row + 1][col] && board[row][col] == board[row + 2][col]){
                        crushed[row][col] = true;
                        crushed[row + 1][col] = true;
                        crushed[row + 2][col] = true;
                        crush = false;
                    }
                }
            }
            
            if(crush){
                break;
            }
            
            int [][] newBoard = new int [rows][cols];
            
            for(int col = cols - 1; col >= 0; col--){
                
                int newRow = rows - 1;
                
                for(int row = rows - 1; row >= 0; row--) {
                
                    while(newRow >= 0 && crushed[newRow][col] == true){
                        newRow--;
                    }
                    
                    if(newRow < 0){
                        break;
                    }

                    newBoard[row][col] = board[newRow][col];
                    newRow--;
                }
            }
            
            board = newBoard;
        }
        
        return board;
    }
}