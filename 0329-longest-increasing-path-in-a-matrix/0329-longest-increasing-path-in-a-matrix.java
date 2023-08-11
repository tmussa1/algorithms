class Solution {
    
        
    public int longestIncreasingPath(int[][] matrix) {
        
        Set<String> visited = new HashSet<>();
        
        int [] [] memo = new int [matrix.length][matrix[0].length];
        
        for(int row = 0; row < matrix.length; row++){
            Arrays.fill(memo[row], -1);
        }
        
        
        int result = 0;
        
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                String key = row + "," + col;
                    result = Math.max(result, 
                                     dfs(row, col, matrix, -1,
                                         memo,
                                        visited));
            }
        }
        
        return result;
    }
    
    private int dfs(int row, int col, int[][] matrix, 
                    int prevValue,
                    int [] [] memo,
                    Set<String> visited){
        
        String key = row + "," + col;
    
        if(row < 0 || col < 0 || row == matrix.length || col == matrix[0].length
           || matrix[row][col] <= prevValue){
            return 0;
        }
        
        visited.add(key);
        
        if(memo[row][col] != -1) return memo[row][col];
        
        int up = dfs(row - 1, col, matrix, matrix[row][col], memo, visited);
        int down = dfs(row + 1, col, matrix, matrix[row][col], memo, visited);
        int left = dfs(row, col - 1, matrix, matrix[row][col], memo, visited);
        int right = dfs(row, col + 1, matrix, matrix[row][col], memo, visited);
        
        int max = 1 + Math.max(Math.max(left, right), Math.max(up, down));
        
        memo[row][col] = max;
        
        return memo[row][col];
    }
}