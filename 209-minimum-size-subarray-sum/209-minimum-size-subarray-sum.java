class Solution {
    
    public int minSubArrayLen(int target, int[] nums) {
        
        int runningSum = 0, windowStart = 0, resLength = nums.length + 1;
        
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){
            
            runningSum += nums[windowEnd];
   
            while(runningSum >= target){
                resLength = Math.min(resLength, windowEnd - windowStart + 1);
                runningSum -= nums[windowStart];
                windowStart++;
            }
        }
        
        return resLength == nums.length + 1 ? 0 : resLength;
    }
}