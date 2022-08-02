class Solution {
    public int jump(int[] nums) {
        int [] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        
        int result = jump(nums, 0, memo);
        
        for(int i = 0; i < memo.length; i++){
          System.out.println(memo[i]);
        }
        
       return result;
    }
    
    private int jump(int[] nums, int index, int [] memo) {
        
        if(index >= nums.length - 1){
            return 0;
        }
        
        if(memo[index] != -1){
            return memo[index];
        }
        
        int jump = Math.min(nums.length - 1, index + nums[index]);
        
        int result = 100000;
        
        for(int i = index + 1; i <= jump; i++){
            result = Math.min(1 + jump(nums, i, memo), result);
        }
        
        memo[index] = result;
        
        return memo[index];
    }
}