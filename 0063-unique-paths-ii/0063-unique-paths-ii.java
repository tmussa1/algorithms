class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        
        int [] [] cache = new int [rows][cols];
        
        for(int row = 0; row < rows; row++){
            if(obstacleGrid[row][0] == 1){
                break;
            } else {
                cache[row][0] = 1;
            }
        }
        
        for(int col = 0; col < cols; col++){
            if(obstacleGrid[0][col] == 1){
                break;
            } else {
                cache[0][col] = 1;
            }
        }
        
        for(int row = 1; row < rows; row++){
           for(int col = 1; col < cols; col++){
             if(obstacleGrid[row][col] == 1){
                cache[row][col] = 0;
             } else {
                cache[row][col] = cache[row - 1][col] + cache[row][col - 1];
             }
           }
        }
        
        return cache[rows - 1][cols - 1];
    }
}