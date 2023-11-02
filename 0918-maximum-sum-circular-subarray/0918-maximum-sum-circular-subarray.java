class Solution {
    
    public int maxSubarraySumCircular(int[] nums) {
        
        int runningSum = 0, otherSum = Integer.MIN_VALUE, maxSum = 0, result = Integer.MIN_VALUE;
        
        int [] suffix = new int[nums.length];
        suffix[nums.length - 1] = nums[nums.length - 1];
        
        int sum = suffix[nums.length - 1];
        
        for(int i = nums.length - 2; i >= 0; i--){
            
            int num = nums[i];
            
            sum += num;
            
            if(sum > suffix[i + 1]){
                suffix[i] = sum;
            } else {
                suffix[i] = suffix[i + 1];
            }
        }
        
        
        for(int i = 0; i < nums.length; i++){
            
            int num = nums[i];
            
            if(num + maxSum > num){
                maxSum += num;
            } else {
                maxSum = num;
            }
            
            if(i + 1 < nums.length){
                otherSum = Math.max(runningSum + suffix[i + 1], otherSum);
            }
            
            runningSum += num;
            
            result = Math.max(result, Math.max(maxSum, otherSum));
        }
        
        return result;
    }
}