class Solution {
    
    public int[] dailyTemperatures(int[] temperatures) {
        
        if(temperatures.length <= 1) return new int [] {0};
        
        Map<Integer, Integer> indexTemprMap = new HashMap<>();
        
        Stack<Integer> indexStack = new Stack<>();
        
        for(int i = 0; i < temperatures.length; i++){
            indexTemprMap.put(i, temperatures[i]);
        }
        
        int [] result = new int[temperatures.length];
        Arrays.fill(result, 0);
        
        for(int i = 0; i < temperatures.length; i++){
            
            int currTempr = temperatures[i];
                
            while(!indexStack.isEmpty() && currTempr > indexTemprMap.get(indexStack.peek())){
                int index = indexStack.pop();
                result[index] = i - index;
            }
            
            indexStack.push(i);
        }
        
      
        return result;
    }
}