class Solution {
    
    public void rotate(int[] nums, int k) {
        
        k %= nums.length;
        
        if(k == 0) return;
        
        int right = nums.length - 1, left = 0;
        
        while(left < k && left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
        
        reverse(nums, 0, k - 1);
        
        reverse(nums, k, nums.length - k - 1);
        
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int [] nums, int left, int right){
        
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    private void swap(int [] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}