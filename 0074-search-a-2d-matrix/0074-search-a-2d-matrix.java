class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int lastCol = matrix[0].length - 1;
        
        int row = 0;
        
        while(row < matrix.length){
            if(matrix[row][lastCol] < target){
                row++;
                continue;
            }
            
            if(binarySearch(matrix[row], target)){
                return true;
            }
            
            if(matrix[row][0] > target) return false;
            
            row++;
        }
        
        return false;
    }
    
    private boolean binarySearch(int [] row, int target){
        
        int left = 0, right = row.length;
        
        while(left <= right){
            
            int mid = left + ((right - left) / 2);
            
            if(row[mid] == target){
                return true;
            } else if(row[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        
        return false;
    }
}