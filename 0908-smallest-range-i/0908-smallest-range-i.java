class Solution {
    public int smallestRangeI(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int left = nums[0], right = nums[nums.length - 1];
        
        if(right - left < 2 * k) return 0;
        
        return right - left - (2 * k);
    }
}