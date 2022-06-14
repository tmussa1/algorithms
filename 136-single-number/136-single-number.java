class Solution {
    
    public int singleNumber(int[] nums) {
      
        Arrays.sort(nums);
        
        int num = 0;
        
        if(nums.length == 1){
            return nums[0];
        }
        
        for(int i = 1; i < nums.length - 2; i++){
            
            if(nums[i] != nums[i - 1] && nums[i] != nums[i + 1]){
                num = nums[i]; 
            }
        }
        
        if(nums[0] != nums[1]){
            num = nums[0];
        }
        
        if(nums[nums.length - 1] != nums[nums.length - 2]){
            num = nums[nums.length - 1];
        }
        
        return num;
    }
}
