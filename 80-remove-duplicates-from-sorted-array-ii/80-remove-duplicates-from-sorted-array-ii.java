class Solution {
    
    public int removeDuplicates(int[] nums) {
        
        int count = 1, prevNum = nums[0], prevNumCount = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == prevNum && prevNumCount >= 2){
                continue;
            } else if(nums[i] == prevNum && prevNumCount < 2){
                nums[count++] = nums[i];
                prevNumCount++;
            } else if(nums[i] != prevNum){
                prevNum = nums[i];
                prevNumCount = 1;
                nums[count++] = nums[i];
            }
        }
        
        return count;
    }
}