class Solution {
    
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        
        int currSum = 0, result = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            currSum += nums[i];
            
            int prefix = currSum - k;
        
            if(prefixMap.containsKey(prefix)){
                result += prefixMap.get(prefix);
            }
            
            prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);
        }
        
        return result;
    }
}