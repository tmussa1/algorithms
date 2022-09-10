class Solution {
    
    public int findUnsortedSubarray(int[] nums) {
        
        int [] snums = nums.clone();
        
        Arrays.sort(nums);
        
        int startIndex = nums.length, endIndex = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(snums[i] != nums[i]){
                startIndex = Math.min(startIndex, i);
                endIndex = Math.max(endIndex, i);
            }
        }
        
        return (endIndex - startIndex >= 0 ? endIndex - startIndex + 1 : 0);
    }
}