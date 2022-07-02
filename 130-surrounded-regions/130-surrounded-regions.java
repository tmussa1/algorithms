class Solution {
    
    public void solve(char[][] board) {
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                
                if(isInBorder(board, row, col) && board[row][col] == 'O'){
                    continue;
                }
                
                if(board[row][col] == 'O' && dfs(board, row, col, new HashSet<>())){
                    markAsX(board, row, col, new HashSet<>());
                }
            }
        }
    }
    
    boolean dfs(char[][] board, int row, int col, Set<String> visited){
        
        if(checkOutofBounds(board, row, col, visited)){
            return true;
        }
        
        if(isInBorder(board, row, col) && board[row][col] == 'O'){
            return false;
        }
        
        visited.add(row + ", " + col);
        
        boolean result = true;
        
        if(row + 1 < board.length && board[row + 1][col] == 'O'){
            result = result && dfs(board, row + 1, col, visited);
        }
        
        if(row - 1 >= 0 && board[row - 1][col] == 'O'){
            result = result && dfs(board, row - 1, col, visited);
        }
        
        if(col + 1 < board[0].length && board[row][col + 1] == 'O'){
            result = result && dfs(board, row, col + 1, visited);
        }
        
        if(col - 1 >= 0 && board[row][col - 1] == 'O'){
            result = result && dfs(board, row, col - 1, visited);
        }
        
        return result;
    }
    
    boolean checkOutofBounds(char[][] board, int row, int col, Set<String> visited){
        
        if(row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 
           || visited.contains(row + ", " + col)){
            return true;
        }
        
        return false;
    }
    
    boolean isInBorder(char[][] board, int row, int col){
        return (row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1);
    }
    
    void markAsX(char[][] board, int row, int col, Set<String> visited){
        
        if(checkOutofBounds(board, row, col, visited) || board[row][col] == 'X'){
            return;
        }
        
        board[row][col] = 'X';
            
        visited.add(row + ", " + col);
        
        markAsX(board, row + 1, col, visited);
        markAsX(board, row - 1, col, visited);
        markAsX(board, row, col + 1, visited);
        markAsX(board, row, col - 1, visited);
    }
}