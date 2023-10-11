class Solution {
    
    public int numIdenticalPairs(int[] nums) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        int count = 0;
        
        for(int num: nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for(Integer key: countMap.keySet()){
            if(countMap.get(key) >= 2){
                count += countMap.get(key) * (countMap.get(key) - 1) / 2;
            }
        }
        
        return count;
    }
}