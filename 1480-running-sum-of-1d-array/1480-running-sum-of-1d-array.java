class Solution {
    public int[] runningSum(int[] nums) {
        
        int index = 1;
        
        while(index < nums.length){
            nums[index] += nums[index - 1];
            index++;
        }
        
        return nums;
    }
}