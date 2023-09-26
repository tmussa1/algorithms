class Solution {
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        Integer [] [] memo = new Integer [nums1.length] [nums2.length];
        
        return maxUncrossedLines(nums1, nums2, 0, 0, memo);
    }
    
    private int maxUncrossedLines(int[] nums1, int[] nums2,
                                  int index1, int index2,
                                  Integer [] [] memo) {
        
        if(index1 == nums1.length || index2 == nums2.length){
            return 0;
        }
        
        if(memo[index1][index2] != null) return memo[index1][index2];
        
        if(nums1[index1] == nums2[index2]){
            memo[index1][index2] = 1 + maxUncrossedLines(nums1, nums2, index1 + 1, index2 + 1, memo);
            return memo[index1][index2];
        }
        
        int result = Math.max(maxUncrossedLines(nums1, nums2, index1 + 1, index2, memo),
                              maxUncrossedLines(nums1, nums2, index1, index2 + 1, memo));
        
        memo[index1][index2] = result;
        
        return memo[index1][index2];
    }
}