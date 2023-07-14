class Solution {
    
    public int[][] matrixReshape(int[][] matrix, int r, int c) {
        
        
        if(r * c != matrix.length * matrix[0].length) return matrix;
        
        int [] [] result = new int[r][c];
        
        int rowIndex = 0, colIndex = 0;
        
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                result[rowIndex][colIndex] = matrix[row][col];
                colIndex++;
                if(colIndex == c){
                    colIndex = 0;
                    rowIndex++;
                }
            }
        }
        
        return result;
    }
}