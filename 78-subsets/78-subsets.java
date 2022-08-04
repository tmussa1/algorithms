class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        backtrack(result, new ArrayList<>(), nums, 0);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currList, int[] nums, int index){
        
        if(currList.size() >= nums.length){
            return;
        }
        
        for(int i = index; i < nums.length; i++){
            
            int curr = nums[i];
                
            currList.add(curr);

            result.add(new ArrayList<>(currList));

            backtrack(result, currList, nums, i + 1);

            currList.remove(currList.size() - 1);
        }
    }
}