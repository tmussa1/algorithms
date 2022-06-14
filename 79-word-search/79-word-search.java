class Solution {
    
    public boolean exist(char[][] board, String word) {
        
        for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[0].length; j++){
             if(board[i][j] == word.charAt(0) && exist(board, word, i, j)){
                return true;
             }
          }
        }
        
        return false;
    }
    
    
    private boolean exist(char[][] board, String word, int row, int col){
        
         if(word == null || word.equals("")){
            return true;
         }
    
         if(checkBounds(row, col, board) && word.charAt(0) == board[row][col]){

            char temp = board[row][col];
            board[row][col] = '*';

            if(exist(board, word.substring(1), row + 1, col)
              || exist(board, word.substring(1), row - 1, col)
              || exist(board, word.substring(1), row, col + 1)
              || exist(board, word.substring(1), row, col - 1)) {
                return true;
            }

            board[row][col] = temp;
         }
        
       
        return false;
    }
    
    private boolean checkBounds(int row, int col, char [][] board){
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}