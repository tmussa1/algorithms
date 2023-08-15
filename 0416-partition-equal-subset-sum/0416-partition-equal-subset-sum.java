class Solution {
    
    public boolean canPartition(int[] nums) {
        
        int sum = Arrays.stream(nums).sum();
        
        if(sum % 2 == 1) return false;
        
        int target = sum / 2;
        
        return partition(nums, 0, target, new Boolean[nums.length][target + 1]);
    }
    
    private boolean partition(int [] nums, int index, int target, Boolean [] [] memo){
        
        if(target == 0) return true;
        
        if(index >= nums.length || target < 0) {
            return false;
        }
        
        if(memo[index][target] != null) return memo[index][target];
        
        boolean canPartition = partition(nums, index + 1, target - nums[index], memo)
            || partition(nums, index + 1, target, memo);
        
        memo[index][target] = canPartition;
        
        return memo[index][target];
    }
}