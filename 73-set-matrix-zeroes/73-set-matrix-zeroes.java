class Solution {
    
    public void setZeroes(int[][] matrix) {
        
        Set<Index> indexes = new HashSet<>();
        
        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column < matrix[0].length; column++){   
                if(matrix[row][column] == 0){
                    indexes.add(new Index(row, column));
                }
            }
        }
        
        for(Index index: indexes){
            
            if(matrix[index.getRow()][index.getColumn()] == 0){
          
                 for(int i = 0; i < matrix.length; i++){
                    matrix[i][index.getColumn()] = 0;
                 }

                 for(int i = 0; i < matrix[0].length; i++){
                    matrix[index.getRow()][i] = 0;
                 }
                
            }
        }
    }
    
    class Index {
        
        int row;
        int column;
        
        Index(int row, int column){
            this.column = column;
            this.row = row;
        }
        
        public int getRow(){
            return this.row;
        }
        
        public int getColumn(){
            return this.column;
        }
    }
}