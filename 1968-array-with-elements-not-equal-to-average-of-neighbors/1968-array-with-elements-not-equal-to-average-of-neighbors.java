class Solution {
    
    public int[] rearrangeArray(int[] nums) {
        
        Arrays.sort(nums);
        
        int[] result = new int[nums.length];
        
        int left = 0, right = nums.length - 1, index = 0;
        
        while(index < nums.length){
            
            if(index % 2 == 0){
                result[index] = nums[left++];
            } else {
                result[index] = nums[right--];
            }
            
            index++;
        }
        
        return result;
    }
}