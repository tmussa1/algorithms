class Solution {
    
    public int missingElement(int[] nums, int k) {
        
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            
            int mid = left + ((right - left) / 2);
            
            int diff = nums[mid] - nums[0] - mid;
            
            if(diff >= k){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return nums[0] + k + right;
    }
}