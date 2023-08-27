class Solution {
    
    public int[][] diagonalSort(int[][] mat) {
        
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a, b) -> {
            
            if(a.diff == b.diff){
                return a.value - b.value;
            }
            
            return a.diff - b.diff;
        });
        
        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat[0].length; col++){
                queue.offer(new Tuple(col - row, mat[row][col]));
            }
        }
        
        for(int row = mat.length - 1; row > 0; row--){
            int newRow = row, newCol = 0;
            
            while(newCol < mat[0].length && newRow < mat.length){
                mat[newRow][newCol] = queue.poll().value;
                newRow++;
                newCol++;
            }
        }
        
        for(int col = 0; col < mat[0].length; col++){
            
            int newRow = 0, newCol = col;
            
            while(newRow < mat.length && newCol < mat[0].length){
                mat[newRow][newCol] = queue.poll().value;
                newRow++;
                newCol++;
            }
        }
        
        
        
        return mat;
    }
    
    class Tuple {
        int diff;
        int value;
        Tuple(int diff, int value){
            this.diff = diff;
            this.value = value;
        }
    }
}