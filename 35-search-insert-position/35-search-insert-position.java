class Solution {
    
    public int searchInsert(int[] nums, int target) {
        
        int index = nums.length;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= target){
                index = i;
                break;
            }
        }
        
        return index;
    }
}