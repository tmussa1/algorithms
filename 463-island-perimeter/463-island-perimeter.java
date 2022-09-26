class Solution {
    
    public int islandPerimeter(int[][] grid) {
        
        int perimeter = 0;
        
        outer:
        for(int row = 0; row < grid.length; row++){
            
            inner:
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1) {
                    perimeter = dfs(grid, row, col, new HashSet<String>());
                    break outer;
                }
            }
        }
        
        return perimeter;
    }
    
    
    private int dfs(int[][] grid, int row, int col, Set<String> visited){
        
        String key = row + "," + col;
        
        if(visited.contains(key) || !isInBounds(grid, row, col) || grid[row][col] == 0){
            return 0;
        }
        
        visited.add(key);
        
        return countSides(grid, row, col) + 
               dfs(grid, row + 1, col, visited) +
               dfs(grid, row - 1, col, visited) + 
               dfs(grid, row, col + 1, visited) +
               dfs(grid, row, col - 1, visited);
    }
    
    private boolean isInBounds(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
    
    private int countSides(int[][] grid, int row, int col){
        
        int sides = 0;
        
        if(row == 0){
            sides++;
        }
        
        if(row == grid.length - 1){
            sides++;
        }
        
        if(col == 0){
            sides++;
        }
        
        if(col == grid[0].length - 1){
            sides++;
        }
        
        if(isInBounds(grid, row - 1, col) && grid[row - 1][col] == 0){
            sides++;
        }
        
        if(isInBounds(grid, row + 1, col) && grid[row + 1][col] == 0){
            sides++;
        }
        
        if(isInBounds(grid, row, col - 1) && grid[row][col - 1] == 0){
            sides++;
        }
        
        if(isInBounds(grid, row, col + 1) && grid[row][col + 1] == 0){
            sides++;
        }
        
        return sides;
    }
}