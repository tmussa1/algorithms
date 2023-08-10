class Solution {
    
    public int maxSubArray(int[] nums) {
        
        int sum = 0, result = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            
            if(sum + nums[i] < nums[i]){
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            
            result = Math.max(result, sum);
        }
        
        return result;
    }
}