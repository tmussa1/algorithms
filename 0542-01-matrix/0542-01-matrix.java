class Solution {
    
    int [] [] directions = new int [] [] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat[0].length; col++){
                if(mat[row][col] == 0){
                    queue.offer(new int []{row, col, 0});
                }
            }
        }
        
        bfs(queue, mat);
        
        return mat;
    }
    
    private void bfs(Queue<int[]> queue, int[][] mat){
        
        Set<String> visited = new HashSet<>();
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int [] pair = queue.poll();
                
                mat[pair[0]][pair[1]] = pair[2];
                
                String key1 = pair[0] + "," + pair[1];
                
                visited.add(key1);
                
                for(int [] dir: directions){
                    
                    int newRow = pair[0] + dir[0];
                    int newCol = pair[1] + dir[1];
                    
                    String key = newRow + "," + newCol;
                    
                    if(newRow < 0 || newCol < 0 || newRow == mat.length || newCol == mat[0].length || visited.contains(key) || mat[newRow][newCol] == 0){
                        continue;
                    }
                    
                    visited.add(key);
                    queue.offer(new int []{newRow, newCol, pair[2] + 1});
                }
            }
            
        }
    }
}