class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
      
        List<List<Integer>> result = new ArrayList<>();
        
        recurse(result, new ArrayList<>(), nums);
        
        return result;
    }
    
    private void recurse(List<List<Integer>> result, List<Integer> currList, int [] nums){
        
        if(currList.size() == nums.length){
            result.add(new ArrayList<>(currList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){ 
            if(!currList.contains(nums[i])){
                currList.add(nums[i]);
                recurse(result, currList, nums);
                currList.remove(currList.size() - 1);
            }     
        }
    }
}
