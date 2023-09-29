class Solution {
    
    public boolean validPartition(int[] nums) {
        return validPartition(nums, 0, new Boolean[nums.length]);
    }
    
    private boolean validPartition(int[] nums, int index, Boolean [] memo) {
        
        if(index >= nums.length) {
            return true;
        }
        
        if(memo[index] != null) {
            return memo[index];
        }
        
        boolean result = false;
        
        if(index + 1 < nums.length && nums[index] == nums[index + 1]){
            result |= validPartition(nums, index + 2, memo);
        }
        
        if(index + 2 < nums.length && nums[index] == nums[index + 1] 
           && nums[index] == nums[index + 2]){
            result |= validPartition(nums, index + 3, memo);
        }
        
        if(index + 2 < nums.length && nums[index + 1] - nums[index] == 1
           && nums[index + 2] - nums[index + 1] == 1){
            result |= validPartition(nums, index + 3, memo);
        }
        
        memo[index] = result;
        
        return result;
    }
}