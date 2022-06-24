class Solution {
    
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        
        int diff = 0;
        
        while(diff < colLength){
            
            int toCompare = matrix[0][diff];
            
            for(int i = 0; i < rowLength; i++){
                
                if(i + diff < colLength && toCompare != matrix[i][i + diff]){
                    return false;
                }
            }
            
            diff++;
        }
        
        int diffRow = 1;
        
        while(diffRow < rowLength){
            
            int toCompare = matrix[diffRow][0];
            
            for(int j = 0; j < colLength; j++){
                
                if(j + diffRow < rowLength && toCompare != matrix[j + diffRow][j]){
                    return false;
                }
            }
            
            diffRow++;
        }
        
        return true;
    }
}