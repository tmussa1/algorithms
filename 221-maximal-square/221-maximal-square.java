class Solution {
    
    public int maximalSquare(char[][] matrix) {
        
        int [] [] cache = new int[matrix.length][matrix[0].length];
        
        int result = 0;
        
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(row > 0 && col > 0 && Integer.parseInt(matrix[row][col] + "") == 1){
                    cache[row][col] = 1 + Math.min(cache[row - 1][col],
                                              Math.min(cache[row][col - 1],
                                                       cache[row - 1][col - 1]));
                } else {
                    cache[row][col] = Integer.parseInt(matrix[row][col] + "");
                }
                
                result = Math.max(result, cache[row][col]);
            }
        }
        
        return result * result;
    }
}