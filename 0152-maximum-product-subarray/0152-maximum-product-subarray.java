class Solution {
    
    public int maxProduct(int[] nums) {
        
        int max = 1, min = 1, result = Integer.MIN_VALUE;
        
        for(int num: nums){
            int temp = max;
            max = Math.max(min * num, Math.max(num, max * num));
            min = Math.min(min * num, Math.min(num, temp * num));
            result = Math.max(result, Math.max(min, max));
        }
        
        return result;
    }
}