class Solution {
    
    public int numSubseq(int[] nums, int target) {
        
        int result = 0, mod = (int) (Math.pow(10, 9) + 7);
        
        Arrays.sort(nums);
        
        int left = 0, right = nums.length - 1;
        
        int [] powers = new int[nums.length];
        
        powers[0] = 1;
        
        for(int i = 1; i < nums.length; i++){
            powers[i] = (powers[i - 1] * 2) % mod;
        }
        
        while(left <= right){
            
            if(nums[left] + nums[right] > target){
                right--;
            } else {
                result += powers[right - left];
                result %= mod;
                left++;
            }
        }
        
        return result % mod;
    }
}