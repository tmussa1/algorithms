class Solution {
    public int rob(int[] nums) {
        
        if(nums.length <= 1){
            return nums[0];
        }
        
        int max1 = robRec(nums, 0, nums.length - 2, new int[nums.length + 1]);
        int max2 = robRec(nums, 1, nums.length - 1, new int[nums.length + 1]);
        
        return Math.max(max1, max2);
    }
    
    private int robRec(int [] nums, int index, int endIndex, int [] memo){
        
        if(index > endIndex){
            return 0;
        }
        
        if(index + 1 <= endIndex && nums[index] == 0 && nums[index + 1] == 0){
            return 0;
        }
        
        if(memo[index] > 0){
            return memo[index];
        }
        
        memo[index] = Math.max(nums[index] + robRec(nums, index + 2, endIndex, memo),
                               robRec(nums, index + 1, endIndex, memo));
        
        return memo[index];
    }
 
}