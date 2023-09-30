class Solution {
    
    public int maxFrequency(int[] nums, int k) {
        
        long sum = 0;
        
        int result = 0;
        
        int left = 0, right = 0;
        
        Arrays.sort(nums);
        
        while(right < nums.length){
            
            sum += nums[right];
            
            long window = ((long)((right - left + 1) * nums[right]));
            
            while(left < right && k + sum < window){
                sum -= nums[left];
                left++;
                window = ((long)((right - left + 1) * nums[right]));
            }
            
            result = Math.max(result, right - left + 1);
            right++;
        }
        
        return result;
    }
}