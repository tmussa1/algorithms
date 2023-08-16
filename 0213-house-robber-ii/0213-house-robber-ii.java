class Solution {
    
    public int rob(int[] nums) {
        
        if(nums.length == 1) return nums[0];
            
        return Math.max(rob(nums, new Integer[nums.length], 0, nums.length - 1),
                       rob(nums,  new Integer[nums.length], 1, nums.length));
    }
    
    private int rob(int[] nums, Integer [] memo, int index, int lastIndex) {
        
        
        if(index >= lastIndex) return 0;
        
        if(memo[index] != null) return memo[index];
        
        int sum = 0;
        
        sum += Math.max(nums[index] + rob(nums, memo, index + 2, lastIndex),
                       rob(nums, memo, index + 1, lastIndex));
        
        memo[index] = sum;
        
        return memo[index];
    }
}