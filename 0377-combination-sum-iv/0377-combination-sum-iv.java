class Solution {
    
    public int combinationSum4(int[] nums, int target) {
        return combinationSum4(nums, target, new Integer[target + 1]);
    }
    
    private int combinationSum4(int[] nums, int target, Integer [] memo) {
        
        if(target < 0) return 0;
            
        if(target == 0) return 1;
        
        if(memo[target] != null) return memo[target];
        
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += combinationSum4(nums, target - nums[i], memo);
        }
        
        memo[target] = sum;
        
        return memo[target];
    }
}