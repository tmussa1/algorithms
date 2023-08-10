class Solution {
    
    public int lengthOfLIS(int[] nums) {
        
        int [] memo = new int[nums.length];
        
        Arrays.fill(memo, 1);
        
        int result = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            int curr = nums[i];
            
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
            
            result = Math.max(result, memo[i]);
        }
        
        return result;
    }
}