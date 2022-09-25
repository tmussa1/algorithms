class Solution {
    
    public int lengthOfLIS(int[] nums) {
        
        int max = 1;
        int [] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < nums.length; i++){
                
            int j = i;

            while(j >= 0){
                if(nums[j] < nums[i] && dp[j] >= dp[i]){
                    dp[i] = dp[j] + 1;
                }
                j--;
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}