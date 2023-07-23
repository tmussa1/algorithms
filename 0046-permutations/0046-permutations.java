class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        permute(result, nums, new LinkedList<Integer>(), new boolean [nums.length]);
        
        return result;
    }
    
    private void permute(List<List<Integer>> result, 
                        int [] nums, 
                        LinkedList<Integer> currList, boolean [] memo){
        
        if(currList.size() == nums.length){
            result.add(new ArrayList<>(currList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!memo[i]){
                memo[i] = true;
                currList.add(nums[i]);
                permute(result, nums, currList, memo);
                currList.removeLast(); 
                memo[i] = false;
            }
        }
    }
}