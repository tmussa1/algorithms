class Solution {
    
    int [] [] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},
                            {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        
    public void gameOfLife(int[][] board) {
        
        Map<String, Integer> sumMap = new HashMap<>();
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                
                String key = row + "," + col;
                int sum = 0;
                
                for(int [] dir: directions){ 
                    int nextRow = row + dir[0], nextCol = col + dir[1];
                    if(isInBounds(board, nextRow, nextCol)){
                         sum += board[nextRow][nextCol];
                    }
                }
                
                sumMap.put(key, sum);
            }
        }
        
        for(Map.Entry<String, Integer> entry: sumMap.entrySet()){
            
            String [] key = entry.getKey().split(",");
            int row = Integer.parseInt(key[0]), col = Integer.parseInt(key[1]);
            
            if(entry.getValue() < 2 || entry.getValue() > 3){
                board[row][col] = 0;
            } else if(entry.getValue() == 3){
                board[row][col] = 1;
            }
        }
    }
    
    private boolean isInBounds(int[][] board, int row, int col){
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length; 
    }
}