class Solution {
    
    public List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> sums = new ArrayList<>();
        sums.add(Arrays.asList(1));
        
        for(int i = 1; i <= rowIndex; i++){
            
            List<Integer> prevList = sums.get(i - 1);
            List<Integer> currList = new ArrayList<>();
            currList.add(prevList.get(0));
            
            for(int j = 1; j < i; j++){
                int val = prevList.get(j - 1) + prevList.get(j);
                currList.add(val);
            }
            
            currList.add(prevList.get(prevList.size() - 1));
            sums.add(currList);
        }
        
        return sums.get(rowIndex);
    }
}