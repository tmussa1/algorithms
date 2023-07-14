class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int [] left = new int[nums.length];
        int [] right = new int[nums.length];
        int [] result = new int[nums.length];
        
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        
        int leftProduct = 1, rightProduct = 1;
        
        for(int i = 0; i < nums.length; i++){
            leftProduct *= nums[i];
            left[i] = leftProduct;
            rightProduct *= nums[nums.length - i - 1];
            right[nums.length - i - 1] = rightProduct;
        }
        
        result[0] = right[1];
        result[nums.length - 1] = left[nums.length - 2];
        
        for(int i = 1; i < nums.length - 1; i++){
           result[i] = left[i - 1] * right[i + 1];
        }
        
        return result;
    }
}