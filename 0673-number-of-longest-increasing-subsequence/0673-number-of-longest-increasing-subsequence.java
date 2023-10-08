class Solution {
    
    public int findNumberOfLIS(int[] nums) {
        
        int [] [] dp = new int[nums.length][2];
        
        int max = 1, result = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            dp[i][0] = 1;
            dp[i][1] = 1;
            
            int j = i - 1;
            
            while(j >= 0){
                
                if(nums[i] > nums[j]){
                    
                    if(dp[j][0] + 1 > dp[i][0]){
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if(dp[j][0] + 1 == dp[i][0]){
                        dp[i][1] += dp[j][1];
                    }

                    max = Math.max(dp[i][0], max);
                } 
                j--;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(dp[i][0] == max){
                result += dp[i][1];
            }
        }
        
        return result;
    }
}