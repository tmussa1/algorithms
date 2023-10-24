class Solution {
    
    int [] [] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        int rows = maze.length;
        int cols = maze[0].length;
        int numDirs = 4;
        
        boolean [] [] [] visited = new boolean[rows][cols][numDirs];
        
        Queue<int []> queue = new LinkedList<>();
        
        for(int i = 0; i < numDirs; i++){
            int row = start[0], col = start[1];
            visited[row][col][i] = true;
            queue.offer(new int[]{row, col, i});
        }
            
        int levels = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int [] curr = queue.poll();
                
                int nextRow = curr[0] + directions[curr[2]][0];
                int nextCol = curr[1] + directions[curr[2]][1];
                
                if(outBounds(maze, nextRow, nextCol)){
                    
                   if(curr[0] == destination[0] && curr[1] == destination[1]){
                      return levels;
                   }
                    
                    int dir = 0;
                    
                    while(dir < 4){
                        
                       nextRow = curr[0] + directions[dir][0];
                       nextCol = curr[1] + directions[dir][1];
                        
                        if(!outBounds(maze, nextRow, nextCol) && !visited[nextRow][nextCol][dir]){
                          visited[nextRow][nextCol][dir] = true;
                          queue.offer(new int[]{nextRow, nextCol, dir});
                        }
                        
                        dir++;
                    }
                    
                   
                    
                } else {
                     visited[nextRow][nextCol][curr[2]] = true;
                     queue.offer(new int[]{nextRow, nextCol, curr[2]});
                }
            }
            
            levels++;
        }
        
        return -1;
    }
    
    private boolean outBounds(int[][] maze, int row, int col){
        return row < 0 || row == maze.length || col < 0 || col == maze[0].length 
            || maze[row][col] == 1;
    }
}