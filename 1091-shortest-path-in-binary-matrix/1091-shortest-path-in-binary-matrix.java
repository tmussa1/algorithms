class Solution {
    
    int [] [] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0},
                            {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int [] {0,0});
        
        Set<String> visited = new HashSet<>();
        visited.add(0 + "," + 0);
        
        int distance = 0;
        
        if(grid[0][0] == 1) return -1;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            int [] curr = queue.peek();
            
            distance++;
            
            for(int i = 0; i < size; i++){
                
                curr = queue.poll();
                
                if(curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1) {
                   return distance;
                }
                
                for(int [] dir: directions){
                    
                    int nextRow = dir[0] + curr[0];
                    
                    int nextCol = dir[1] + curr[1];
                    
                    String key = nextRow + "," + nextCol;
                    
                    if(nextRow >= 0 && nextCol >= 0 && nextRow < grid.length
                      && nextCol < grid[0].length && !visited.contains(key)
                      && grid[nextRow][nextCol] == 0){
                        queue.offer(new int [] {nextRow, nextCol});
                        visited.add(key);
                    }
                    
                }
            }
        }
        
        return -1;
    }
}