class Solution {
    
    public int rob(int[] nums) {
        return rob(nums, new HashMap<>(), 0);
    }
    
    private int rob(int[] nums, Map<Integer, Integer> memo, int index) {
        
        if(index >= nums.length) return 0;
        
        if(memo.containsKey(index)) return memo.get(index);
        
        int robbed = Math.max(nums[index] + rob(nums, memo, index + 2),
                              rob(nums, memo, index + 1));
        
        memo.put(index, robbed);
        
        return memo.get(index);
    }
}