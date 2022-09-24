class Solution {
    
    public int[] shuffle(int[] nums, int n) {
        
        int [] result = new int[nums.length];
        int index = 0, offsetIndex = n, outputIndex = 0;
        
        while(outputIndex < nums.length){
            if(outputIndex % 2 == 0){
                result[outputIndex] = nums[index];
                index++;
            } else {
                result[outputIndex] = nums[offsetIndex];
                offsetIndex++;
            }  
            outputIndex++;
        }
        
        return result;
    }
}