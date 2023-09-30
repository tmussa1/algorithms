class Solution {
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        for(int index = 0; index < nums.length; index++){
            
            int ind = Math.abs(nums[index]) - 1;
            
            if(nums[ind] < 0){
                continue;
            }
            
            nums[ind] *= -1;
        }
        
        for(int index = 0; index < nums.length; index++){
            if(nums[index] > 0){
                result.add(index + 1);
            }
        }
        
        return result;
    }
}