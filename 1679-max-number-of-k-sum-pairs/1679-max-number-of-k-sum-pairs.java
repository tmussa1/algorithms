class Solution {
    
    public int maxOperations(int[] nums, int k) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            int currNum = nums[i], remainder = k - nums[i];
            
            if(countMap.containsKey(remainder)){
                
                count++;
                countMap.put(remainder, countMap.getOrDefault(remainder, 0) - 1);
                
                if(countMap.get(remainder) == 0){
                    countMap.remove(remainder);
                }
                
            } else {
                countMap.put(currNum, countMap.getOrDefault(currNum, 0) + 1);
            }
        }
        
        return count;
    }
}