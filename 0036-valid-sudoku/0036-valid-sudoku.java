class Solution {
    public boolean isValidSudoku(char[][] board) {
       
        for(int row = 0; row < board.length; row++){
            if(doesColExist(board, row)){
                return false;
            }
        }
        
        for(int col = 0; col < board[0].length; col++){
            if(doesRowExist(board, col)){
                return false;
            }
        }
        
        return !doesDiagonalExist(board, 0, 0)
            && !doesDiagonalExist(board, 0, 3)
            && !doesDiagonalExist(board, 0, 6)
            && !doesDiagonalExist(board, 3, 0)
            && !doesDiagonalExist(board, 3, 3)
            && !doesDiagonalExist(board, 3, 6)
            && !doesDiagonalExist(board, 6, 0)
            && !doesDiagonalExist(board, 6, 3)
            && !doesDiagonalExist(board, 6, 6);
    }
    
    private boolean doesDiagonalExist(char[][] board, int beginRow, int beginCol){
        
        Set<Character> values = new HashSet<>();
        
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                
              if(board[beginRow + row][beginCol + col] == '.'){
                  continue;
              }
                
              if(values.contains(board[beginRow + row][beginCol + col])){
                return true;
              }
                
              values.add(board[beginRow + row][beginCol + col]);
            }
        }
        
        return false;
    }
    
    private boolean doesRowExist(char[][] board, int col){
        
        Set<Character> values = new HashSet<>();
        
        for(int row = 0; row < board.length; row++){
            
            if(board[row][col] == '.'){
                  continue;
            }
            
            if(values.contains(board[row][col])){
                return true;
            }
            values.add(board[row][col]);
        }
        
        return false;
    }
    
    private boolean doesColExist(char[][] board, int row){
        
        Set<Character> values = new HashSet<>();
        
        for(int col = 0; col < board[0].length; col++){
            
            if(board[row][col] == '.'){
                  continue;
            }
            
            if(values.contains(board[row][col])){
                return true;
            }
            values.add(board[row][col]);
        }
        
        
        return false;
    }
}