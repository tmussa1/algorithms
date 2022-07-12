class Solution {
    
    public boolean isMajorityElement(int[] nums, int target) {
        
        int majoritySize = nums.length / 2;
        
        int currMajority = 0;
        
        int index = 0;
        
        while(index < nums.length){
            
            int curr = nums[index], firstIndex = index;
            
            while(index + 1 < nums.length && nums[index + 1] == curr){
                index++;
            }
            
            currMajority = Math.max(currMajority, index - firstIndex + 1);
            
            if(currMajority > majoritySize && curr == target){
                return true;
            }
            
            index++;
        }
        
        return false;
    }
}