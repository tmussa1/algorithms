class Solution {
    
    public int longestSubarray(int[] nums) {
        
        int zeroCount = 0;
        
        boolean foundZero = false;
        
        int left = 0, right = 0, result = 0;
        
        while(right < nums.length){
            
            if(nums[right] == 0){
                zeroCount++;
                foundZero = true;
            }
            
            while(left < nums.length && zeroCount > 1){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            
            result = Math.max(result, right - left);
            
            right++;
        }
        
        return foundZero ? result : nums.length - 1;
    }
}