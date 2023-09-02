class Solution {
    
    public int shortestBridge(int[][] grid) {
        
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        
        outer:
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    findIsland(grid, visited, row, col);
                    break outer;
                }
            }
        }
        
        int [] [] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addAll(visited);
        
        int distance = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                Pair<Integer, Integer> curr = queue.poll();
                
                for(int [] dir: directions){
                    
                    int nextRow = dir[0] + curr.getKey(),
                        nextCol = dir[1] + curr.getValue();
                    
                    Pair<Integer, Integer> newPair = new Pair(nextRow, nextCol);
                    
                    if(invalid(grid, nextRow, nextCol) || visited.contains(newPair)){
                        continue;
                    }
                    
                    if(grid[nextRow][nextCol] == 1) return distance;
                    
                    queue.offer(newPair);
                    visited.add(newPair);
                }
            }
            
            distance++;
        }
        
        return distance;
    }
    
    private void findIsland(int[][] grid, Set<Pair<Integer, Integer>> visited, 
                            int row, int col){
        
        Pair<Integer, Integer> pair = new Pair(row, col);
        
        if(invalid(grid, row, col) || grid[row][col] == 0 || visited.contains(pair)){
            return;
        }
        
        visited.add(pair);
        
        findIsland(grid, visited, row + 1, col);
        findIsland(grid, visited, row - 1, col);
        findIsland(grid, visited, row, col + 1);
        findIsland(grid, visited, row, col - 1);
    }
    
    private boolean invalid(int[][] grid, int row, int col){
        return row < 0 || row == grid.length || col < 0 || col == grid[0].length;
    }
}