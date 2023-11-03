class Solution {
    
    int [] [] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
    public int shortestPathAllKeys(String[] grid) {
        
        Queue<int []> queue = new LinkedList<>();
        
        Set<Character> keySet = new HashSet<>();
        
        Set<String> visited = new HashSet<>();
        
        int keyCount = 0;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length(); col++){
                
                char c = grid[row].charAt(col);
                
                if(c == '@'){
                    queue.offer(new int [] {row, col, 0, 0});
                }
                
                if(Character.isLowerCase(c)) {
                    keyCount += (1 << (c - 'a'));
                    keySet.add(c);
                }
            }
        }
        
        char [] [] board = new char[grid.length][grid[0].length()];
        
        for(int row = 0; row < grid.length; row++){
            board[row] = grid[row].toCharArray();
        }
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int [] curr = queue.poll();
                
                int keyCurr = curr[3];
                
                for(int [] dir: directions){
                    
                    int nextRow = curr[0] + dir[0];
                    int nextCol = curr[1] + dir[1];
                    
                    String key1 = nextRow + "," + nextCol + "," + keyCurr;
    
                    if(nextRow < 0 || nextRow == grid.length || nextCol < 0 || nextCol == grid[0].length() || board[nextRow][nextCol] == '#'){
                        continue;
                    }
                
                    char currChar = board[nextRow][nextCol];
                    
                    int keyNext = (1 << (currChar - 'a'));
                    
                    if(keySet.contains(currChar)){

                        if((keyCurr & keyNext) != 0){
                            continue;
                        }

                        int keyNext2 = (keyCurr | keyNext);
                        
                        if(keyNext2 == keyCount) return curr[2] + 1;
                        
                        queue.offer(new int [] {nextRow, nextCol, curr[2] + 1, keyNext2});
                        
                    }
                    
                    if(Character.isUpperCase(currChar) && ((1 << (currChar - 'A')) & keyCurr) == 0){
                        continue;
                    } else if(!visited.contains(key1)){
                        queue.offer(new int [] {nextRow, nextCol, curr[2] + 1, curr[3]});
                    }
                    
                    visited.add(key1);
                }
                
                
           }
        }
        
        return -1;
    }
}