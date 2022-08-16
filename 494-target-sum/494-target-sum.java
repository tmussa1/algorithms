class Solution {
   public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int targetSum = (sum + target) / 2;
        
        if(((sum + target) & 1) == 1 || targetSum < 0){
            return 0;
        }
       
        Integer [] [] memo = new Integer[targetSum + 1][nums.length];
        return findTargetSumWays(nums, targetSum, 0, memo);
    }
    private int findTargetSumWays(int[] nums, int targetSum, int index,
                                  Integer [] [] memo){
        
        if(index == nums.length){
            return targetSum == 0 ? 1 : 0;
        }
        
        if(targetSum < 0){
            return 0;
        }
        
        if(memo[targetSum][index] == null){
            int count1 = 0, count2 = 0;
            count1 = findTargetSumWays(nums, targetSum - nums[index], index + 1, memo);
            count2 = findTargetSumWays(nums, targetSum, index + 1, memo);
            memo[targetSum][index] = count1 + count2;
        }
        
        return memo[targetSum][index];
    }
}