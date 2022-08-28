class Solution {
    public boolean searchMatrix(int[][] matrix, int target) { 
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = findRow(matrix, target); 
        return findTarget(matrix, target, row);    
    }
    
    private boolean findTarget(int [][] matrix, int target, int row){
        
        if(row > matrix.length -1){
            return false;
        }
        
        for(int i = 0; i < matrix[row].length; i++){
            if(matrix[row][i] == target){
                return true;
            }
        }
        return findTarget(matrix, target, row + 1);
    }
   
    private int findRow(int[][] matrix, int target){
        int index = 0;
        for(int i = 0; i < matrix.length; i++){
            if(target <= matrix[i][matrix[i].length - 1]){
                index = i;
                break;
            }
        }
        return index;
    }
}