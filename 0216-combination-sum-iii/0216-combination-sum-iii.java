class Solution {
    
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        int [] nums = new int[9];
        
        for(int i = 0; i < 9; i++){
            nums[i] = i + 1;
        }
        
        combinations(result, new LinkedList<>(), k, n, 0, nums, 0);
        
        return result;
    }
    
    private void combinations(List<List<Integer>> result, LinkedList<Integer> currList, int k, int n, int currSum, int [] nums, int index){
        
        if(currSum == n && currList.size() == k){
            result.add(new ArrayList<>(currList));
            return;
        }
        
        if(currSum > n || currList.size() > k || index >= nums.length){
            return;
        }
        
        currList.add(nums[index]);
     //   System.out.println(currList);
        combinations(result, currList, k, n, currSum + nums[index], nums, index + 1);
        currList.removeLast();
        combinations(result, currList, k, n, currSum, nums, index + 1);
    }
}