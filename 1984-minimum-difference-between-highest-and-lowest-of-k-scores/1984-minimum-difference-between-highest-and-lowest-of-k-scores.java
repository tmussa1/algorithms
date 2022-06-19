class Solution {
    
    public int minimumDifference(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int range = nums[k - 1] - nums[0];
        
        for(int i = k; i < nums.length; i++){
            
            if(nums[i] - nums[i - k + 1] < range){
                range = nums[i] - nums[i - k + 1];
            }
        }
        
        return range;
    }
}