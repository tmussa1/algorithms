class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Set<List<Integer>> result = new HashSet<>();
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(countMap.containsKey(nums[i])){
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }
        }
        
        recurse(result, countMap, nums, new ArrayList<>());
        
        return new ArrayList<>(result);
    }
    
    private void recurse(Set<List<Integer>> result, Map<Integer, Integer> countMap, 
                        int [] nums, List<Integer> currList){
        
        if(currList.size() == nums.length){
            result.add(new ArrayList<>(currList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            
            if(!currList.contains(nums[i]) 
               || countMap.get(nums[i]) > 0){
                currList.add(nums[i]);
                countMap.put(nums[i], countMap.get(nums[i]) - 1);
                recurse(result, countMap, nums, currList);
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
                currList.remove(currList.size() - 1);
            }
        }
    }
}