class Solution {
    
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        combinations(result, new LinkedList<>(), k, n, 0, 1);
        
        return result;
    }
    
    private void combinations(List<List<Integer>> result, LinkedList<Integer> currList, int k, int n, int currSum, int num){
        
        if(currSum == n && currList.size() == k){
            result.add(new ArrayList<>(currList));
            return;
        }
        
        if(currSum > n || currList.size() > k || num >= 10){
            return;
        }
        
        currList.add(num);
        combinations(result, currList, k, n, currSum + num, num + 1);
        currList.removeLast();
        combinations(result, currList, k, n, currSum, num + 1);
    }
}