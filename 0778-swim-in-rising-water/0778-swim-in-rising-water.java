class Solution {
    
    int [] [] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int swimInWater(int[][] grid) {
        
        int rows = grid.length, cols = grid[0].length;
        
        PriorityQueue<int []> queue = new PriorityQueue<int []>((a, b) -> {
            return a[0] - b[0];
        });
        
        queue.offer(new int [] {grid[0][0], 0, 0});
        
        int [] [] visited = new int[rows][cols];
        
        for(int i = 0; i < rows; i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int [] curr = queue.poll();
                
                if(curr[1] == rows - 1 && curr[2] == cols - 1){
                    return curr[0];
                }
                
                for(int [] dir: directions){
                    
                    int nextRow = curr[1] + dir[0];
                    int nextCol = curr[2] + dir[1];
                    
                    if(nextRow < 0 || nextRow == rows || nextCol < 0 || nextCol == cols){
                        continue;
                    }
                    
                    int height = Math.max(curr[0], grid[nextRow][nextCol]);
                    
                    if(height < visited[nextRow][nextCol]){
                        queue.offer(new int [] {height, nextRow, nextCol});
                        visited[nextRow][nextCol] = height;
                    }
                }
            }
        }
        
        return -1;
    }
}