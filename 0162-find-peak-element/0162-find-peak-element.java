class Solution {
    
    public int findPeakElement(int[] nums) {
        
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            
            int mid = left + ((right - left) / 2);
            
            if((mid == 0 || mid > 0 && nums[mid - 1] < nums[mid])
               && (mid == nums.length - 1 || mid + 1 <= nums.length - 1 
               && nums[mid + 1] < nums[mid])){
                return mid;
            } else if(mid > 0 && nums[mid - 1] > nums[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
}