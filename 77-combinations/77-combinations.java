class Solution {
    
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new LinkedList<>();
        
        generateCombinations(n, k, 1, new LinkedList<Integer>(), result);
        
        return result;
    }
    
    private void generateCombinations(int n, int k, int index, LinkedList<Integer> currSet, 
                                      List<List<Integer>> result){
        
        if(currSet.size() == k){
            result.add(new LinkedList(currSet));
        }
        
        for(int i = index; i <= n; ++i){
            currSet.add(i);
            generateCombinations(n, k, i + 1, currSet, result);
            currSet.removeLast();
        }
    }
}