class Solution {
    
    public List<String> summaryRanges(int[] nums) {
        
        int index = 0;
        
        List<String> result = new ArrayList<>();
        
        while(index < nums.length){
            
            int curr = nums[index] - 1;
            int firstIndex = index;
            
            while(index < nums.length && curr == nums[index] - 1){
                curr = nums[index];
                index++;
            }
            
            if(index == firstIndex + 1){
                result.add(nums[firstIndex] + "");
            } else {
                result.add(nums[firstIndex] + "->" + nums[index - 1]);
            }
            
        }
        
        return result;
    }
}