class Solution {
    
    public int partitionArray(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int index = 1, min = nums[0], numPartitions = 1;
        
        while(index < nums.length){
            
            int curr = nums[index];
            
            if(curr - min > k){
                numPartitions++;
                min = curr;
            }
            
            index++;
        }
        
        return numPartitions;
    }
}