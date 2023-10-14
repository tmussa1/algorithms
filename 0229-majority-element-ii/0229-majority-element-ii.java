class Solution {
    
    public List<Integer> majorityElement(int[] nums) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int num: nums){
            
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            
            if(countMap.size() > 2){
                Map<Integer, Integer> newMap = new HashMap<>();
                for(Integer key: countMap.keySet()){
                    countMap.put(key, countMap.getOrDefault(key, 0) - 1);  
                    if(countMap.get(key) > 0){
                        newMap.put(key, countMap.get(key));
                    }
                }
                countMap = newMap;
            }
        }
        
        Map<Integer, Integer> countMap2 = new HashMap<>();
        
        for(int num: nums){
            countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(Integer key: countMap.keySet()){
            if(countMap2.get(key) >= (nums.length / 3) + 1) {
                result.add(key);
            }
        }
        
        return result;
    }
}