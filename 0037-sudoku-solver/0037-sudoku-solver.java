class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board.length; col++){
                if(board[row][col] == '.'){
                    for(char val = '1'; val <= '9'; val++){
                        if(validSudoku(board, val, row, col)){
                            char temp = board[row][col];
                            board[row][col] = val;
                            if(solve(board)) {
                                return true;
                            } 
                            board[row][col] = temp;
                        }
                    }
                return false;
           }   
        }
        }
        return true;
    }

    private boolean validSudoku(char[][] board, char val, int row, int col){

        int rowBox = row / 3;
        int colBox = col / 3;

        for(int i = 0; i < board.length; i++){
            if(val == board[i][col]){
                return false;
            }
            if(val == board[row][i]){
                return false;
            }
        }

        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                if(board[(3 * rowBox) + r][(3 * colBox) + c] == val){
                    return false;
                }
            }
        }

        return true;
    }
}