class Solution {
    
    public int minimizeMax(int[] nums, int p) {
        
        if(p == 0) return 0;
        
        Arrays.sort(nums);
        
        long left = 0;
        long right = Arrays.stream(nums).max().getAsInt();
        
        long result = Long.MAX_VALUE;
        
        while(left <= right){
            
            long mid = left + ((right - left) / 2);
            
            if(containsPDifferences(nums, p, mid)){
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return (int) result;
    }
    
    private boolean containsPDifferences(int[] nums, int p, long val){
        
        int count = 0, index = 0;
        
        while(index < nums.length - 1){
            
            if(Math.abs(nums[index] - nums[index + 1]) <= val) {
                count++;
                index++;
            }
            
            index++;
            
            if(count == p) return true;
        }
        
        return false;
    }
}