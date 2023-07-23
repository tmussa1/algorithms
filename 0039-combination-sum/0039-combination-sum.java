class Solution {
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        
        List<List<Integer>> result = new ArrayList<>();
        
        generateCombinations(result, new LinkedList<>(), candidates, target, 0, 0);
        
        return result;
    }
    
    private void generateCombinations(List<List<Integer>> result,
                                      LinkedList<Integer> currList,
                                      int[] candidates, 
                                      int target, 
                                      int currSum,
                                      int index){
        
        if(currSum > target || index == candidates.length){
            return;
        }
        
        if(currSum == target){
            result.add(new ArrayList<>(currList));
        }
        
        
        for(int i = index; i < candidates.length; i++){
            currList.add(candidates[i]);
            generateCombinations(result, currList, candidates, target, 
                                 currSum + candidates[i], i);
            currList.removeLast();
        }
        
    }
}