class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
       int row = 0, col = 0;
        
       while(row < matrix.length && matrix[row][col] < target) {
          row++;
       }
    
       if(row > 0 && (row >= matrix.length || matrix[row][col] > target)) row--;
    
       if(matrix[row][col] == target) return true;
    
       int left = 0, right = matrix[0].length - 1;
    
       int [] matrixRow = matrix[row];
    
       while(left <= right){
           
           int middle = left + ((right - left) / 2);
           
           if(matrixRow[middle] < target){
               left = middle + 1;
           } else if(matrixRow[middle] > target){
               right = middle - 1;
           } else {
               return true;
           }
       }
       
       return false;
    }
}