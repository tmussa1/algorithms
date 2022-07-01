class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        
        boolean incrementCol = false, incrementRow = false, decrementCol = false, decrementRow = false;
        
        int round = 0;
        
        int row = 0, col = 0;
        
        int size = matrix.length * matrix[0].length;
        
        while(result.size() < size){
            
            result.add(matrix[row][col]);
            
            if(row == round && col < matrix[0].length - round - 1){
                incrementCol = true;
                incrementRow = false;
                decrementCol = false;
                decrementRow = false;
            } else if(col == matrix[0].length - round - 1 && row < matrix.length - round - 1){
                incrementCol = false;
                incrementRow = true;
                decrementCol = false;
                decrementRow = false;
            } else if(row == matrix.length - round - 1 && col != round){
                incrementCol = false;
                incrementRow = false;
                decrementCol = true;
                decrementRow = false;
            } else if(col == round){
                incrementCol = false;
                incrementRow = false;
                decrementCol = false;
                decrementRow = true;
            }
            
            if(incrementCol == true){
                col++;
            }
            
            if(incrementRow == true){
                row++;
            }
            
            if(decrementCol == true){
                col--;
            }
            
            if(decrementRow == true){
                
                row--;
                
                if(row == round){
                    round++;
                    row = round;
                    col = round;
                }
            }
        }
        
        return result;
    }
}