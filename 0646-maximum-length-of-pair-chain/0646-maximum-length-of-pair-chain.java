class Solution {
    
    public int findLongestChain(int[][] pairs) {
        
        int longest = 1;
        
        int [] dp = new int[pairs.length];
        
        Arrays.sort(pairs, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        for(int i = 0; i < pairs.length; i++){
            
            int start = pairs[i][0];
            int j = i - 1;
            dp[i] = 1;
            
            while(j >= 0){
                
                if(pairs[j][1] < start){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                
                j--;
            }
            
            longest = Math.max(longest, dp[i]);
        }
        
        return longest;
    }
}