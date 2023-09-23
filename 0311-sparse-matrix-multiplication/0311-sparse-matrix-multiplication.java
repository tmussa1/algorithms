class Solution {
    
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        
        int mat1Row = mat1.length;
        int commonCol = mat1[0].length;
        int mat2Col = mat2[0].length;
        
        int [] [] result = new int [mat1Row][mat2Col];
        
        for(int row = 0; row < mat1Row; row++){
            
          for(int row2 = 0; row2 < commonCol; row2++){
                for(int col = 0; col < mat2Col; col++){
                    int val1 = mat1[row][row2];
                    int val2 = mat2[row2][col];
                    result[row][col] += (val1 * val2);
                }
           }
        }
        
        return result;
    }
}