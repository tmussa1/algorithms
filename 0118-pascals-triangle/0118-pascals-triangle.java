class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1)));
        
        
        for(int i = 1; i < numRows; i++){
            List<Integer> prevList = result.get(i - 1);
            List<Integer> currList = new ArrayList<>();
            currList.add(prevList.get(0));
            
            for(int j = 1; j < i; j++){
                int val = prevList.get(j - 1) + prevList.get(j);
                currList.add(val);
            }
            
            currList.add(prevList.get(prevList.size() -1));
            
            result.add(currList);
        }
        
        return result;
    }
}