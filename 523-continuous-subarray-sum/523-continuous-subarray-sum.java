class Solution {
    
    public boolean checkSubarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);
        
        int runningSum = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            runningSum += nums[i];
            
            runningSum = runningSum % k;
            
            if(prefixMap.containsKey(runningSum)){
                if(i - prefixMap.get(runningSum) > 1){
                    return true;
                }
            }
            
            if(!prefixMap.containsKey(runningSum)){
                prefixMap.put(runningSum, i);
            }
        }
        
        return false;
    }
}

// 23, 25, 29, 35, 42
// 5, 1, 5