class Solution {
    
    public int lengthOfLIS(int[] nums) {
        
        int [] memo = new int [nums.length];
        
        int result = 0;
        
        Arrays.fill(memo, 1);
        
        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < currNum){
                    max = Math.max(max, memo[j]);
                }
            }
            memo[i] = max + 1;
            result = Math.max(result, memo[i]);
        }
        
        return result;
    }
}