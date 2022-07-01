class Solution {
    
    public int twoSumLessThanK(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int left = 0, right = nums.length - 1, result = -1, sum = 0, minDiff = Integer.MAX_VALUE;
        
        while(left < right){
            
            sum = nums[left] + nums[right];
            
            if(sum < k){
                left++;
            } else {
                right--;
            }
            
            if(k - sum > 0 && k - sum < minDiff){
                minDiff = k - sum;
                result = sum;
            }
        }
        
        return result;
    }
}