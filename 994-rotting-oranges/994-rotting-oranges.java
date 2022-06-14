class Solution {
    
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> queue = new LinkedList<>();
        
        int fresh = 0, time = 0;
        
        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == 2){
                    
                    queue.add(new int[]{i, j});
                    
                } else if(grid[i][j] == 1){
                    
                    fresh++;
                }
            }
        }
        
        int [][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        
        while(!queue.isEmpty() && fresh > 0){
            
            time++;
        
            int size = queue.size();
            
            while(size-- > 0){
                
                int [] coord = queue.poll();
                
                for(int [] direction: directions){

                    int nextRow = coord[0] + direction[0];
                    int nextCol = coord[1] + direction[1];

                    if(nextRow >= grid.length || nextRow < 0 
                       || nextCol >= grid[0].length || nextCol < 0 || grid[nextRow][nextCol] == 2 
                       || grid[nextRow][nextCol] == 0){
                        continue;
                    }

                    queue.add(new int[]{nextRow, nextCol});

                    grid[nextRow][nextCol] = 2;

                    fresh--;
                }
            }
            
        }
        
        return fresh == 0 ? time : -1;
    }
}