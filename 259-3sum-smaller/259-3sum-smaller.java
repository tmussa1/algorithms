class Solution {
    
    public int threeSumSmaller(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) return 0;
            
        Arrays.sort(nums);
        
        int result = 0;
        
        if(target > 0 && nums[0] > target){
            return result;
        }
        
        for(int i = 0; i < nums.length; i++){
            result += twoSum(nums, i, target);
        }
        
        return result;
    }
    
    private int twoSum(int [] nums, int index, int target){
    
        int low = index + 1, high = nums.length - 1;
        
        int result = 0;
        
        while(low < nums.length && low < high){
            
            int sum = nums[low] + nums[index] + nums[high];
            
            if(sum < target){
                result++;
            }
            
            high--;
            
            if(high == low){
                low++;
                high = nums.length - 1;
            }
        }
        
        return result;
    }
}