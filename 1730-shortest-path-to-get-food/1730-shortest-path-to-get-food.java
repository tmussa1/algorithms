class Solution {
    
    public int getFood(char[][] grid) {
        
        int [] []  directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        int startRow = -1, startCol = -1;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == '*'){
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }
        
        Set<String> visited = new HashSet<>();
            
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int [] {startRow, startCol});
        
        int pathLength = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int [] top = queue.poll();
                
                if(grid[top[0]][top[1]] == '#'){
                    return pathLength;
                }
                
                visited.add(top[0] + "," + top[1]);
                
                for(int [] direction: directions){
                    
                    int row = direction[0] + top[0];
                    int col = direction[1] + top[1];
                    
                    if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited.contains(row + "," + col) && grid[row][col] != 'X'){
                        queue.offer(new int [] {row, col});
                        visited.add(row + "," + col);
                    }
                }
            }
            
            pathLength++;
        }
        
        return -1;
    }
}