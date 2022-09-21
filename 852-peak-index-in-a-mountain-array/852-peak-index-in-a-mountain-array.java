class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int left = 0, right = arr.length - 1;
        int [] nums = arr;
        
        while(left <= right){
            
            int mid = left + ((right - left) / 2);
            
            if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]){
                return mid;
            }
            
            if(nums[mid] >= nums[left]){
                if(nums[mid] < nums[mid + 1]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}