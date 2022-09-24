class Solution {
    public int[][] transpose(int[][] matrix) {
        
        int[][] transpose = new int [matrix[0].length] [matrix.length];
        
        for(int row = 0; row < matrix[0].length; row++){
            for(int col = 0; col < matrix.length; col++){
                transpose[row][col] = matrix[col][row];
            }
        }
        
        return transpose;
    }
}