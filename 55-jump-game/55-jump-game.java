class Solution {
    public boolean canJump(int[] nums) {
        int [] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        boolean result = canJump(nums, 0, memo);
        return result;
    }
    
    private boolean canJump(int[] nums, int index, int [] memo) {
        
        if(index >= nums.length - 1){
            return true;
        }
        
        if(memo[index] != -1){
            return memo[index] == 1 ? true : false;
        }
        
        int jump = Math.min(nums.length - 1, index + nums[index]);
        
        for(int j = index + 1; j <= jump; j++){
            if(canJump(nums, j, memo)) {
                memo[index] = 1;
                return true;
            }
        }
        
        memo[index] = 2;
        
        return false;
    }
}