class Solution {
    
    public long evenProduct(int[] nums) {
        
        long sum = 0;
        
        long [] dp = new long [nums.length];
        
        long max = 0;
        
        int lastEvenIndex = -1;
        
        for(int index = 0; index < nums.length; index++){

            if(nums[index] % 2 == 0){
                lastEvenIndex = index;
            }
            
            dp[index] += Math.max(lastEvenIndex + 1, 0);

            max += dp[index];
        }
        
        return max;
    }
}