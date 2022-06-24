class Solution {
    
    public void rotate(int[][] matrix) {
        
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int rowRound = 0, colRound = 0;
        
        while(rowRound < (rowLength / 2)) {
            
            int topLeft = matrix[rowRound][colRound];
            int topRight = matrix[colRound][colLength - 1 - rowRound];
            int bottomRight  = matrix[rowLength - 1 - rowRound][colLength - 1 - colRound];
            int bottomLeft = matrix[rowLength - 1 - colRound][rowRound];
            
            matrix[colRound][colLength - 1 - rowRound] = topLeft;
            matrix[rowLength - 1 - rowRound][colLength - 1 - colRound] = topRight;
            matrix[rowLength - 1 - colRound][rowRound] =  bottomRight;
            matrix[rowRound][colRound] = bottomLeft;
            
            colRound++;
            
            if(colRound == colLength - 1 - rowRound){
                rowRound++;
                colRound = rowRound;
            }
        }
    }
}