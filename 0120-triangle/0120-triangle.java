class Solution {
    
    public int minimumTotal(List<List<Integer>> triangles) {
        
        int length = triangles.size();
        
        int [] [] dp = new int[length][length];
        
        for(int i = 0; i < length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[0][0] = triangles.get(0).get(0);
        
        int row = 1, min = Integer.MAX_VALUE;
        
        if(length == 1) {
           min = Math.min(min, dp[0][0]);
        }
        
        while(row < length){
            
            List<Integer> prev = triangles.get(row - 1);
            List<Integer> curr = triangles.get(row);
            
            int col = 0;
            
            while(col < curr.size()){
                if(col - 1 >= 0){
                    dp[row][col] = Math.min(dp[row - 1][col - 1], dp[row][col]);
                }
                dp[row][col] = Math.min(dp[row - 1][col], dp[row][col]) + curr.get(col);
                if(row == length - 1) {
                   min = Math.min(min, dp[row][col]);
                }
                col++;
            }
    
            row++;
        }
        
        return min;
    }
}