class Solution {
    public boolean isMonotonic(int[] nums) {
        
        if(nums.length <= 1) return true;
        
        boolean increasing = false, decreasing = false;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
               increasing = true;
            }
            if(nums[i] < nums[i - 1]){
                decreasing = true;
            }
            if(increasing && nums[i] < nums[i - 1]){
                return false;
            }
            if(decreasing && nums[i] > nums[i - 1]){
                return false;
            }
        }
        
        return true;
    }
}