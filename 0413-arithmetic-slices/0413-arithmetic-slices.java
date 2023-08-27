class Solution {
    
    public int numberOfArithmeticSlices(int[] nums) {
        
        int result = 0;
        
        if(nums.length < 3) return result;
        
        int diff = 0;
        
        int left = 0, right = 1;
        
        while(left < nums.length && right < nums.length){
            
            diff = nums[right] - nums[right - 1];
            
            while(right < nums.length && diff == nums[right] - nums[right - 1]){
                right++;
            }
            
            System.out.println("diff " + diff + " right " + right);
            
            int length = right - left;
            
            result += (length - 1) * (length - 2) / 2;
            
            left = right - 1;
            
            System.out.println("left " + left);
        }
        
        return result;
    }
}