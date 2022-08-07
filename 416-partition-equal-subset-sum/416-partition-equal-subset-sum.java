class Solution {
    public boolean canPartition(int[] nums) {
        
        Integer sum = Arrays.stream(nums).sum();
        
        if(sum % 2 == 1){
            return false;
        }
        
        int targetSum = sum / 2;
        
        Arrays.sort(nums);
        
        Boolean [] [] memo = new Boolean [targetSum + 1][nums.length + 1];
        
        return canPartitionHelper(nums, targetSum, 0, memo);
    }
    
    private boolean canPartitionHelper(int [] nums, int targetSum, int index,
                                       Boolean [] [] memo){
        
        if(targetSum == 0){
            return true;
        }
        
        if(index >= nums.length || targetSum < 0){
            return false;
        }
        
        if(memo[targetSum][index] != null){
            return memo[targetSum][index];
        }
            
        boolean result = canPartitionHelper(nums, targetSum - nums[index], index + 1, memo)
                     || canPartitionHelper(nums, targetSum, index + 1, memo);
        
        memo[targetSum][index] = result;
        
        return memo[targetSum][index];
    }
}