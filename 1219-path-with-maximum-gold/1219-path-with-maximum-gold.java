class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int rowLength = grid.length, colLength = grid[0].length;
        
        int result = 0;
        
        boolean [] [] seen = new boolean[rowLength][colLength];
        
        for(int row = 0; row < rowLength; row++){
            for(int col = 0; col < colLength; col++){
                result = Math.max(result, dfs(grid, row, col, seen));
            }
        }
        
        return result;
    }
    
    int dfs(int [] [] grid, int row, int col, boolean [] [] seen){
        
        if(outOfBounds(grid, row, col) || seen[row][col] == true || grid[row][col] == 0){
            return 0;
        }
        
        seen[row][col] = true;
        
        int left = dfs(grid, row, col - 1, seen);
        int right = dfs(grid, row, col + 1, seen);
        int up = dfs(grid, row - 1, col, seen);
        int down = dfs(grid, row + 1, col, seen);
        
        seen[row][col] = false;
        
        return grid[row][col] + Math.max(left, Math.max(right, Math.max(up, down)));
    }
    
    boolean outOfBounds(int [] [] grid, int row, int col){
        return row < 0 || col < 0 || row >= grid.length || col >= grid[0].length;
    }
}