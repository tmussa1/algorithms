class Solution {
    public String tictactoe(int[][] moves) {
        
        char [][] grid = new char[3][3];
        
        for(int i = 0; i < moves.length; i++){
            
            if(i % 2 == 0){
                grid[moves[i][0]][moves[i][1]] = 'X';
            } else {
                grid[moves[i][0]][moves[i][1]] = 'O';
            }
        }
        
        if(sumsToTarget(grid, 'X')){
            return "A";
        }
        
        if(sumsToTarget(grid, 'O')){
            return "B";
        }
        
        return moves.length < 9 ? "Pending" : "Draw";
    }
    
    private boolean sumsToTarget(char [][] grid, char targetChar){

        return   bottomRightDiagonalSum(grid, targetChar)
              || topLeftDiagonalSum(grid, targetChar)
              || rowColSum(grid[0], targetChar)
              || rowColSum(grid[1], targetChar)
              || rowColSum(grid[2], targetChar)
              || rowColSum(findColumns(grid, 0), targetChar)
              || rowColSum(findColumns(grid, 1), targetChar)
              || rowColSum(findColumns(grid, 2), targetChar);
    }
    
    private char [] findColumns(char [][] grid, int col){
        
        char [] columns = new char[grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            columns[i] = grid[i][col];
        }
        
        return columns;
    }
    
    private boolean bottomRightDiagonalSum(char [][] grid, char targetChar){
        
        int runningSum = 0;
        
        for(int i = 0; i < grid.length; i++){
            if(grid[i][i] == targetChar) {
                runningSum++;
            }
        }
        
        return runningSum == 3;
    }
    
    private boolean topLeftDiagonalSum(char [][] grid, char targetChar){
        
        int runningSum = 0;
        
        runningSum += grid[0][2] == targetChar ? 1 : 0;
        runningSum += grid[1][1] == targetChar ? 1 : 0;
        runningSum += grid[2][0] == targetChar ? 1 : 0;
        
        return runningSum == 3;
    }
    
    private boolean rowColSum(char [] row, char targetChar){
        
        int runningSum = 0;
        
        for(int i = 0; i < row.length; i++){
            if(row[i] == targetChar){
                runningSum++;
            }
        }
        
        return runningSum == 3;
    }
}