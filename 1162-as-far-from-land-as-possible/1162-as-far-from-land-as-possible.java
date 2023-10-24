class Solution {
    
   int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int maxDistance(int[][] grid) {
        
        Queue<int []> queue = new LinkedList<>();
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    queue.offer(new int [] {row, col, 0});
                }
            }
        }
        
        return bfs(queue, grid);
    }
    
    private int bfs(Queue<int []> queue, int[][] grid){
        
        int max = Integer.MIN_VALUE;
        
        Set<String> visited = new HashSet<>();
        
        while(!queue.isEmpty()){
            
            int [] curr = queue.poll();
            
            visited.add(curr[0] + "," + curr[1]);
            
            max = Math.max(max, curr[2]);
            
            for(int i = 0; i < directions.length; i++){
                
                int x = curr[0] + directions[i][0];
                int y = curr[1] + directions[i][1];
                int distance = Math.abs(x - curr[0]) + Math.abs(y - curr[1]);
                String key = x + "," + y;
                
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                   && !visited.contains(key) && grid[x][y] == 0){
                    queue.add(new int [] {x, y, curr[2] + distance});
                    visited.add(key);
                }
            }
        }
        
        return max == Integer.MIN_VALUE || max == 0 ? -1 : max;
    }
}