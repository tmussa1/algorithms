class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] left = new int[nums.length];
        int [] right = new int[nums.length];
        int [] output = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            if(i - 1 >= 0) {
                left[i] = left[i - 1] * nums[i];
            } else {
                left[i] = nums[i];
            }
        }
        
        output[nums.length - 1] = left[nums.length - 2];
        
        
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + 1 < nums.length){
                right[i] = right[i + 1] * nums[i];
            } else {
                right[i] = nums[i];
            }
        }
        
        output[0] = right[1];
        
        for(int i = 1; i < nums.length - 1; i++){
            output[i] = left[i - 1] * right[i + 1];
        }
        
        return output;
    }
}