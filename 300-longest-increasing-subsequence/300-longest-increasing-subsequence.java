class Solution {
    
    public int lengthOfLIS(int[] nums) {
        
        int max = 0;
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
        }
        
        return Arrays.stream(dp).max().getAsInt();
    }
}