class Solution {
    
    public int pivotIndex(int[] nums) {
        
        int runningSumLeft = 0, sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        
         for(int i = 0; i < nums.length; i++){
            if(runningSumLeft == sum - runningSumLeft - nums[i]) return i;
            runningSumLeft += nums[i];
        }
        
        return -1;
    }
}