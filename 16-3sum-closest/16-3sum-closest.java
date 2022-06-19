class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int result = nums[0] + nums[1] + nums[2];
        
        if((target > 0 && nums[0] > target) || (target < 0 && nums[0] > 0)){
            return result;
        }
        
        for(int i = 0; i < nums.length; i++){
            result = twoSumClosest(nums, target, result, i);
        }
        
        return result;
    }
    
    int twoSumClosest(int [] nums, int target, int result, int index){
        
        int low = index + 1, high = nums.length - 1;
        
        while(low < high){
            
            int sum = nums[index] + nums[low] + nums[high];
            
            if(sum > target){
                high--;
            } else if(sum < target){
                low++;
            } else {
                return sum;
            } 
            
            if(result == Integer.MAX_VALUE || Math.abs(target - sum) < Math.abs(target - result)){
                result = sum;
            }
        }
        
        return result;
    }
}