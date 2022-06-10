class Solution {
    
    public int maxSubArray(int[] nums) {
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        for(int index = 1; index < nums.length; index++){
            if(dp[index - 1] + nums[index] > nums[index]){
               dp[index] = dp[index - 1] + nums[index];
            } else {
               dp[index] = nums[index];
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < dp.length; i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        
        return max;
    }
}