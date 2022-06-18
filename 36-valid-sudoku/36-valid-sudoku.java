class Solution {
    public boolean isValidSudoku(char[][] board) {
       
        Set<Character> uniqueNumbers = new HashSet<>();
        
        for(int row = 0; row < board.length; row++){
            
            uniqueNumbers = new HashSet<>();
            
            for(int column = 0; column < board[0].length; column++){
                
                if(Character.isDigit(board[row][column])){
                    
                    if(uniqueNumbers.contains(board[row][column])){
                        return false;
                    } else {
                        uniqueNumbers.add(board[row][column]);
                    }
                }
            }
        }
        
       for(int column = 0; column < board[0].length; column++){
           
           uniqueNumbers = new HashSet<>();
           
             for(int row = 0; row < board.length; row++){
                 
                 if(Character.isDigit(board[row][column])){
             
                    if(uniqueNumbers.contains(board[row][column])){
                        return false;
                    } else {
                        uniqueNumbers.add(board[row][column]);
                    }
                 }
             }
       }
        
       if(  !validateSmallBox(board, 0, 2, 0, 2)
         || !validateSmallBox(board, 0, 2, 3, 5)
         || !validateSmallBox(board, 0, 2, 6, 8)
         || !validateSmallBox(board, 3, 5, 0, 2)
         || !validateSmallBox(board, 3, 5, 3, 5)
         || !validateSmallBox(board, 3, 5, 6, 8)
         || !validateSmallBox(board, 6, 8, 0, 2)
         || !validateSmallBox(board, 6, 8, 3, 5)
         || !validateSmallBox(board, 6, 8, 6, 8)){
           return false;
       }
        
       return true;
    }
    

    private boolean validateSmallBox(char[][] board, int startRow, 
                                     int endRow, int startColumn, int endColumn){
        
        Set<Character> uniqueNumbers = new HashSet<>();
        
        for(int i = startRow; i <= endRow; i++){
            for(int j = startColumn; j <= endColumn; j++){         
              if(Character.isDigit(board[i][j])){ 
                if(uniqueNumbers.contains(board[i][j])){
                    return false;
                } else {
                    uniqueNumbers.add(board[i][j]);
                }
              }
            }
        }
        
        return true;
    }
}