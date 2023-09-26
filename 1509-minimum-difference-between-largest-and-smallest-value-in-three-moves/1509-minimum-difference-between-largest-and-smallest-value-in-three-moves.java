class Solution {
    
    public int minDifference(int[] nums) {
        
        Arrays.sort(nums);
        
        int length = nums.length - 1, diff = Integer.MAX_VALUE;
        
        if(length <= 3) return 0;
        
        diff = Math.min(diff, Math.abs(nums[0] - nums[length - 3]));
        diff = Math.min(diff, Math.abs(nums[1] - nums[length - 2]));
        diff = Math.min(diff, Math.abs(nums[2] - nums[length - 1]));
        diff = Math.min(diff, Math.abs(nums[3] - nums[length]));
        
        return diff;
    }
}