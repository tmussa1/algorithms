class TicTacToe {

    int [] [] board;
    int n, player1 = 1, player2 = -1;
    
    public TicTacToe(int n) {
        this.n = n;
        this.board = new int[n][n];
    }
    
    boolean wonRow(int row, int target){
        
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += board[row][i];
        }
        
        return sum == target;
    }
    
    boolean wonColumn(int col, int target){
        
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += board[i][col];
        }
        
        return sum == target;
    }
    
    boolean wonDiagonal(int target){
        
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += board[i][i];
        }
        
        return sum == target;
    }
    
    boolean wonReverseDiagonal(int target){
        
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += board[i][n - i - 1];
        }
        
        return sum == target;
    }
    
    public int move(int row, int col, int player) {
        
        if(player == 1){
            
            board[row][col] = player1;
            
            if(wonRow(row, n) || wonColumn(col, n) 
              || wonDiagonal(n) || wonReverseDiagonal(n)){
                return player;
            }
            
        } else {
            
            board[row][col] = player2;
            
            if(wonRow(row, -1 * n) || wonColumn(col, -1 * n) 
              || wonDiagonal(-1 * n) || wonReverseDiagonal(-1 * n)){
                return player;
            }
        }
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */