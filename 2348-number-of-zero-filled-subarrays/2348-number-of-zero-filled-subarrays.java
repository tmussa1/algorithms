class Solution {
    
    public long zeroFilledSubarray(int[] nums) {
        
        int index = 0;
        
        long sum = 0;
        
        while(index < nums.length){
            
            int firstIndex = index;
            
            while(index < nums.length && nums[index] == 0){
                index++;
            }
            
            long length = ((long) (index - firstIndex));
            long prod = ((length + 1) * length) / 2;
            sum += prod;
            index++;
        }
        
        return sum;
    }
}