class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int length = r * c, countRow = 0, countCol = 0;
        
        if(mat.length * mat[0].length != length) return mat;
        
        int [] [] result = new int[r][c];
        
        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat[0].length; col++){
                result[countRow][countCol] = mat[row][col];
                countCol++;
                if(countCol == c){
                    countCol = 0;
                    countRow++;
                }
            }
        }
        
        return result;
    }
}