class Solution {
    
    public int largestUniqueNumber(int[] nums) {
        
        int max = -1;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max && countMap.get(nums[i]) == 1){
                max = nums[i];
            }
        }
        
        return max;
    }
}