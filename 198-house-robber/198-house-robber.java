class Solution {
    public int rob(int[] nums) {
        
        int [] memo = new int[nums.length + 1];
        nums = Arrays.copyOf(nums, nums.length + 1);
        
        return rob(nums, 0, memo);
    }
    
    private int rob(int [] nums, int index, int [] memo){
        
        if(index + 1 >= nums.length){
            return 0;
        }
        
        if(nums[index] == 0 && nums[index + 1] == 0){
            return 0;
        }
        
        if(memo[index] > 0){
            return memo[index];
        }
        
        int first = nums[index] + rob(nums, index + 2, memo);
        int second = nums[index + 1] + rob(nums, index + 3, memo);
        
        memo[index] = Math.max(first, second);
        
        return memo[index];
    }
}