class Solution {
    
    public int diagonalSum(int[][] mat) {
        
        int dim = mat.length - 1, sum = 0;
        
        for(int i = 0; i <= dim; i++){
            sum += mat[i][i];
        }
        
        for(int i = dim; i >= 0; i--){
            if(dim - i != i){
                sum += mat[dim - i][i];
            }
        }
        
        return sum;
    }
}