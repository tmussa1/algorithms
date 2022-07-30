class Solution {
    public int maxProduct(int[] nums) {
        
        int max_so_far = nums[0], min_so_far = nums[0], max = nums[0];
        
        for(int i = 1; i < nums.length; i++){

            int temp = max_so_far;
            max_so_far = Math.max(nums[i], Math.max(min_so_far * nums[i], max_so_far * nums[i]));
            min_so_far = Math.min(Math.min(temp * nums[i], min_so_far * nums[i]), nums[i]);
            
            if(max_so_far > max){
                max = max_so_far;
            }
        }
        
        return max;
    }
}