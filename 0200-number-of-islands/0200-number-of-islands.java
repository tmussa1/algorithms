class Solution {
    
    int [] [] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        
        int islands = 0;
        
        Set<String> visited = new HashSet<>();
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    dfs(visited, grid, row, col);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private void dfs(Set<String> visited, char[][] grid,
                     int row, int col){
        
        String key = row + "," + col;
        
        if(visited.contains(key) || isBorder(grid, row, col) || grid[row][col] == '0'){
            return;
        }
        
        visited.add(key);
        grid[row][col] = '0';
        
        for(int [] direction: directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            dfs(visited, grid, newRow, newCol);
        }
    }
    
    private boolean isBorder(char [][] grid, int row, int col){
        return row < 0 || row == grid.length || col < 0 || col == grid[0].length;
    }
    
}