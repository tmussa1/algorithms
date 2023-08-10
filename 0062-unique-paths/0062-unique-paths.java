class Solution {
    
    public int uniquePaths(int m, int n) {
        
        int [] [] memo = new int[m][n];
        
        for(int i = 0; i < m; i++){
            memo[i][0] = 1;
        }
        
        for(int i = 0; i < n; i++){
            memo[0][i] = 1;
        }
        
        for(int row = 1; row < m; row++){
            for(int col = 1; col < n; col++){
                memo[row][col] = memo[row - 1][col] + memo[row][col - 1];
            }
        }
        
        return memo[m - 1][n - 1];
    }
}