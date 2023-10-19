class Solution {
    
    int [] [] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int nearestExit(char[][] maze, int[] entrance) {
        
        Queue<int []> queue = new LinkedList<>();
        queue.offer(entrance);
        
        Set<String> visited = new HashSet<>();
        visited.add(entrance[0] + "," + entrance[1]);
        
        int rows = maze.length, cols = maze[0].length, steps = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int [] curr = queue.poll();
                String key = curr[0] + "," + curr[1];
                
                if((curr[0] != entrance[0] || curr[1] != entrance[1]) && (curr[0] == 0 || curr[0] == rows - 1 || curr[1] == 0 || curr[1] == cols - 1)){
                    return steps;
                }
                
                for(int [] dir: directions){
                    
                    int nextRow = curr[0] + dir[0];
                    int nextCol = curr[1] + dir[1];
                    String key1 = nextRow + "," + nextCol;
                    
                    if(!visited.contains(key1) && nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && maze[nextRow][nextCol] == '.'){
                        queue.offer(new int [] {nextRow, nextCol});
                        visited.add(key1);
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
}