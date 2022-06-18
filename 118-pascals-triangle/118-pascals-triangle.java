class Solution {
    
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        result.add(lst);
        
        for(int i = 1; i < numRows; i++){
          List<Integer> prev = result.get(i - 1);
          Integer [] next = new Integer[i + 1];
          next[0] = 1;
          next[i] = 1;
            
          int firstIndex = 1, lastIndex = i;
            
          while(firstIndex < lastIndex){
              next[firstIndex] = prev.get(firstIndex - 1) + prev.get(firstIndex);
              firstIndex++;
          }
            
          result.add(Arrays.asList(next));
        }
        
        return result;
    }
}