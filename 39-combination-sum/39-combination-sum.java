class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Set<List<Integer>> result = new HashSet<>();
        
        generateCombinations(result, candidates, target, 0, 0, new LinkedList<Integer>());
        
        return new ArrayList<>(result);
    }
    
    private void generateCombinations(Set<List<Integer>> result, 
                                      int[] candidates, int target,
                                      int currSum,
                                      int index, LinkedList<Integer> currList){
        
        if(currSum > target || index >= candidates.length){
            return;
        }
        
        if(target == currSum){
            result.add(new ArrayList<>(currList));
        }
        
        currList.add(candidates[index]);
        generateCombinations(result, candidates, target, currSum + candidates[index], index,
                            currList);
        currList.removeLast();
        generateCombinations(result, candidates, target, currSum, index + 1,
                            currList);
    }
}