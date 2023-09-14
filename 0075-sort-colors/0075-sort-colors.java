class Solution {
    
    public void sortColors(int[] nums) {
        
        int twoPointer = nums.length - 1, curr = 0, zeroPointer = 0;
        
        while(curr <= twoPointer){
            
            if(nums[curr] == 2){
                int temp = nums[curr];
                nums[curr] = nums[twoPointer];
                nums[twoPointer--] = temp;
            } else if(nums[curr] == 0){
                int temp = nums[curr];
                nums[curr++] = nums[zeroPointer];
                nums[zeroPointer++] = temp;
            } else {
                curr++;
            }
        }
    }
}