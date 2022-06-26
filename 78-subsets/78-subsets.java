class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        
        Set<Set<Integer>> result = new HashSet<>();
        result.add(new HashSet<>());
        
        backtrack(result, new HashSet<>(), nums, 0);
        
        Set<List<Integer>> finalResult = new HashSet<>();
        
        for(Set<Integer> elements: result){
            finalResult.add(new ArrayList<>(elements));
        }
        
        return new ArrayList<>(finalResult);
    }
    
    private void backtrack(Set<Set<Integer>> result, Set<Integer> currList, int[] nums, int index){
        
        if(currList.size() >= nums.length){
            return;
        }
        
        for(int i = index; i < nums.length; i++){
            
            int curr = nums[i];
            
            if(!currList.contains(curr)){
                
                currList.add(curr);

                result.add(new HashSet<>(currList));

                backtrack(result, currList, nums, index + 1);

                currList.remove(curr);
            }
        }
    }
}